package org.ijunfu;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.ijunfu.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.util.List;

/**
 *
 * @Title          <Title>
 * @Description    <TODO>
 *
 * @author weijunfu<ijunfu @ 1 6 3 . com>
 * @date 2022/01/24 13:54
 * @version 1.0.0
 *
 */

@SpringBootTest
public class MongoDBTest {

    @Autowired
    MongoTemplate mongo;

    @Test
    void connection() {
        ConnectionString connectionString = new ConnectionString("mongodb+srv://ijunfu:Weizg123456@demo.esvju.mongodb.net/myFirstDatabase?retryWrites=true&w=majority");
        MongoClientSettings settings = MongoClientSettings.builder()
                .applyConnectionString(connectionString)
                .build();
        MongoClient mongoClient = MongoClients.create(settings);
        System.out.println(mongoClient);

        MongoDatabase database = mongoClient.getDatabase("test");
        database.createCollection("ijunfu");

        MongoCollection<Document> collection = database.getCollection("ijunfu");
        System.out.println(collection);


        mongoClient.close();
    }

    @Test
    void save() {
        Book book = new Book();
        book.setId(1l);
        book.setName("springboot");
        book.setAuthor("ijunfu");
        book.setPublisher("...");
        book.setRemarks("test");

        mongo.save(book);
    }

    @Test
    void find() {
        List<Book> books = mongo.findAll(Book.class);
        System.out.println(books);
    }
}
