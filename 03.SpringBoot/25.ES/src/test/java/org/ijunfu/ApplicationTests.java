package org.ijunfu;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpHost;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.search.SearchResponseSections;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.elasticsearch.client.indices.GetIndexResponse;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.core.TimeValue;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.rest.RestStatus;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.ijunfu.domain.Book;
import org.ijunfu.mapper.BookMapper;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
class ApplicationTests {

    static RestHighLevelClient client;

    @Autowired
    BookMapper bookMapper;

    // 初始化
    @BeforeAll
    static void init() throws IOException {

        HttpHost host = HttpHost.create("http://localhost:9200");
        RestClientBuilder builder = RestClient.builder(host);

        CredentialsProvider credentialsProvider = new BasicCredentialsProvider();
        credentialsProvider.setCredentials(AuthScope.ANY, new UsernamePasswordCredentials("<username>", "<password>"));
        builder.setHttpClientConfigCallback(f -> f.setDefaultCredentialsProvider(credentialsProvider));
        client = new RestHighLevelClient(builder);
    }

    // 创建索引
    @Test
    void createIndex() throws IOException {
        CreateIndexRequest booksIndexRequest = new CreateIndexRequest("books");
        client.indices().create(booksIndexRequest, RequestOptions.DEFAULT);
    }

    // 获取索引
    @Test
    void getIndex() throws IOException {
        GetIndexRequest booksIndexRequest = new GetIndexRequest("books");
        GetIndexResponse response = client.indices().get(booksIndexRequest, RequestOptions.DEFAULT);

        System.out.println(Arrays.asList(response.getIndices()));
    }

    // 删除索引
    @Test
    void deleteIndex() throws IOException {
        DeleteIndexRequest deleteIndexRequest = new DeleteIndexRequest("books");
        client.indices().delete(deleteIndexRequest, RequestOptions.DEFAULT);
    }

    // 使用分词器创建索引
    @Test
    void createIndexWithIK() throws IOException {
        CreateIndexRequest booksIndexRequest = new CreateIndexRequest("books");
        String json = "{\n" + "  \"mappings\": {\n" + "    \"properties\": {\n" + "      \"id\": {\n" + "        \"type\": \"keyword\"\n" + "      },\n" + "      \"name\": {\n" + "        \"type\": \"text\",\n" + "        \"analyzer\": \"ik_max_word\"\n" + "      },\n" + "      \"author\": {\n" + "        \"type\": \"text\",\n" + "        \"analyzer\": \"ik_max_word\",\n" + "        \"copy_to\": \"all\"\n" + "      },\n" + "      \"publishTime\": {\n" + "        \"type\": \"keyword\"\n" + "      },\n" + "      \"price\": {\n" + "        \"type\": \"keyword\"\n" + "      },\n" + "      \"remarks\": {\n" + "        \"type\": \"text\",\n" + "        \"analyzer\": \"ik_max_word\",\n" + "        \"copy_to\": \"all\"\n" + "      },\n" + "      \"all\": {\n" + "        \"type\": \"text\",\n" + "        \"analyzer\": \"ik_max_word\"\n" + "      }\n" + "    }\n" + "  }\n" + "}";
        booksIndexRequest.source(json, XContentType.JSON);
        client.indices().create(booksIndexRequest, RequestOptions.DEFAULT);
    }

    // 创建文档
    @Test
    void createDoc() throws IOException {
        Book book = bookMapper.selectById(1l);
        System.out.println(book);

        ObjectMapper jsonMapper = new ObjectMapper();
        String json = jsonMapper.writeValueAsString(book);
        System.out.println(json);

        IndexRequest indexRequest = new IndexRequest("books").id("1");
        indexRequest.source(json, XContentType.JSON);
        client.index(indexRequest, RequestOptions.DEFAULT);
    }

    @Test
    void createDocs() throws IOException {
        List<Book> books = bookMapper.selectList(null);

        BulkRequest bulk = new BulkRequest();

        for(Book book : books) {
            ObjectMapper jsonMapper = new ObjectMapper();
            String json = jsonMapper.writeValueAsString(book);
            System.out.println(json);

            IndexRequest indexRequest = new IndexRequest("books").id(book.getId().toString());
            indexRequest.source(json, XContentType.JSON);
            bulk.add(indexRequest);
        }

        client.bulk(bulk, RequestOptions.DEFAULT);

    }

    @Test
    void getDocById() throws IOException {
        GetRequest request = new GetRequest("books", "1");
        GetResponse response = client.get(request, RequestOptions.DEFAULT);
        String json = response.getSourceAsString();
        System.out.println(json);
    }

    @Test
    void getDocByCondition() throws IOException {
        SearchRequest request = new SearchRequest("books");
        SearchSourceBuilder builder = new SearchSourceBuilder();
        builder.query(QueryBuilders.termQuery("name", "语文"));
        request.source(builder);
        SearchResponse response = client.search(request, RequestOptions.DEFAULT);

        RestStatus status = response.status();
        System.out.println(status.getStatus());
        Assertions.assertEquals(200, status.getStatus());

        SearchHit[] hits = response.getHits().getHits();
        if(hits.length>0) {
            for(SearchHit hit : hits) {
                String json = hit.getSourceAsString();
                System.out.println(json);

                ObjectMapper jsonMapper = new ObjectMapper();
                Book book = jsonMapper.readValue(json, Book.class);
                System.out.println(book);
            }
        }

    }

    @AfterAll
    static void close() {
        try {
            client.close();
        } catch (IOException e) {
            client = null;
        }
    }

}
