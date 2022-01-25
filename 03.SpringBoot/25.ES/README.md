# ElasticSearch(ES)
`ElasticSearch`是一个分布式全文搜索引擎。

## 安装 & 配置

### Windows版

+ [https://www.elastic.co/cn/downloads/elasticsearch | 下载](https://www.elastic.co/cn/downloads/elasticsearch)

### 启动
```shell
bin\elasticsearch.bat
```

### 测试

访问: [http://localhost:9200](http://localhost:9200)


## 基本操作

### 1. 创建索引
> 创建`books`索引，在关系型数据库中相当于创建了`books`数据库

```http request
PUT http://localhost:9200/books
Accept: application/json
```

若`books`索引已存在，则报错`resource_already_exists_exception`。


### 2. 查询索引
```http request
GET http://localhost:9200/books
Accept: application/json
```

若索引不存在，则报错`index_not_found_exception`。

### 3. 删除索引
```http request
DELETE http://localhost:9200/books
Accept: application/json
```

若索引不存在，则报错`index_not_found_exception`。

## IK分词器

### 下载

+ [https://github.com/medcl/elasticsearch-analysis-ik/releases | ik 分词器](https://github.com/medcl/elasticsearch-analysis-ik/releases)

### 配置
将下载的`zip`文件解压至`elasticsearch`中`plugins`目录下

### 重启 ElasticSearch

须重启`ElasticSearch`才能加载分词器

### 使用分词器创建索引
```http request
PUT http://localhost:9200/books
Accept: application/json
Content-Type: application/json

{
  "mappings": {
    "properties": {
      "id": {
        "type": "keyword"
      },
      "name": {
        "type": "text",
        "analyzer": "ik_max_word"
      },
      "author": {
        "type": "text",
        "analyzer": "ik_max_word",
        "copy_to": "all"
      },
      "publishTime": {
        "type": "keyword"
      },
      "price": {
        "type": "keyword"
      },
      "remarks": {
        "type": "text",
        "analyzer": "ik_max_word",
        "copy_to": "all"
      },
      "all": {
        "type": "text",
        "analyzer": "ik_max_word"
      }
    }
  }
}
```

+ `keyword`: 关键字
+ `analyzer`: 分词器
+ `copy_to`: 分组，常用于组合查询

## 文档

### 创建文档的三种方式

#### 1. 随机ID
```http request
POST http://localhost:9200/books/_doc
Content-Type: application/json
Accept: application/json

{
  "id": 1,
  "name": "springboot",
  "author": "ijunfu",
  "publishTime": "2022-01-25",
  "price": 99.00,
  "remarks": "test data"
}
```


#### 2. 指定ID
```http request
POST http://localhost:9200/books/_doc/2
Content-Type: application/json
Accept: application/json

{
  "id": 1,
  "name": "springboot",
  "author": "ijunfu",
  "publishTime": "2022-01-25",
  "price": 99.00,
  "remarks": "test data"
}
```

#### 3. 指定ID
```http request
POST http://localhost:9200/books/_create/3
Content-Type: application/json
Accept: application/json

{
"id": 1,
"name": "springboot",
"author": "ijunfu",
"publishTime": "2022-01-25",
"price": 99.00,
"remarks": "test data"
}
```

### 查询

#### 查询指定文档

```http request
GET http://localhost:9200/books/_doc/2
Accept: application/json
```

#### 查询所有文档
```http request
GET http://localhost:9200/books/_search
Accept: application/json
```

#### 按条件查询
```http request
GET http://localhost:9200/books/_search?q=name:springboot
Accept: application/json
```

### 删除文档
```http request
DELETE http://localhost:9200/books/_doc/2
Accept: application/json
```

### 修改文档

#### 全覆盖式修改
```http request
PUT http://localhost:9200/books/_doc/3
Accept: application/json
Content-Type: application/json

{
  "author": "wei"
}
```

#### 增量修改
```http request
POST http://localhost:9200/books/_update/4
Accept: application/json
Content-Type: application/json

{
  "doc": {
    "author": "wei"
  }
}
```

## SpringBoot 整合 ElasticSearch

### 1. 引入依赖
```xml
<dependency>
    <groupId>org.elasticsearch.client</groupId>
    <artifactId>elasticsearch-rest-high-level-client</artifactId>
</dependency>
```

### 2. 测试
```java
@SpringBootTest
class ApplicationTests {

    static RestHighLevelClient client;

    // 初始化
    @BeforeAll
    static void init() throws IOException {

        HttpHost host = HttpHost.create("http://localhost:9200");
        RestClientBuilder builder = RestClient.builder(host);
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

    // 关闭资源
    @AfterAll
    static void close() {
        try {
            client.close();
        } catch (IOException e) {
            client = null;
        }
    }

}
```

### 创建单文档
```
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
```

### 批量创建文档
```
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
```

### 根据ID查询文档
```
@Test
void getDocById() throws IOException {
    GetRequest request = new GetRequest("books", "1");
    GetResponse response = client.get(request, RequestOptions.DEFAULT);
    String json = response.getSourceAsString();
    System.out.println(json);
}
```

### 根据条件查询文档
```
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
```

## 扩展

### 使用账号登录ElasticSearch
```
HttpHost host = HttpHost.create("http://localhost:9200");
RestClientBuilder builder = RestClient.builder(host);

CredentialsProvider credentialsProvider = new BasicCredentialsProvider();
credentialsProvider.setCredentials(AuthScope.ANY, new UsernamePasswordCredentials("<username>", "<password>"));
builder.setHttpClientConfigCallback(f -> f.setDefaultCredentialsProvider(credentialsProvider));
RestHighLevelClient client = new RestHighLevelClient(builder);
```