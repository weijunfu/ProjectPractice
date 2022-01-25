package org.ijunfu;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.elasticsearch.client.indices.GetIndexResponse;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.Arrays;

@SpringBootTest
class ApplicationTests {

    static RestHighLevelClient client;

    @BeforeAll
    static void init() throws IOException {

        HttpHost host = HttpHost.create("http://localhost:9200");
        RestClientBuilder builder = RestClient.builder(host);
        client = new RestHighLevelClient(builder);
    }

    @Test
    void createIndex() throws IOException {
        CreateIndexRequest booksIndexRequest = new CreateIndexRequest("books");
        client.indices().create(booksIndexRequest, RequestOptions.DEFAULT);
    }

    @Test
    void getIndex() throws IOException {
        GetIndexRequest booksIndexRequest = new GetIndexRequest("books");
        GetIndexResponse response = client.indices().get(booksIndexRequest, RequestOptions.DEFAULT);

        System.out.println(Arrays.asList(response.getIndices()));
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
