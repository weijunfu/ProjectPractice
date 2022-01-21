package org.ijunfu;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

//@SpringBootTest(properties = {"test.author=ijunfu"})
@SpringBootTest(args = {"--test.author=ijunfu"})
class ApplicationTests {

    @Value("${test.msg}")
    private String msg;

    @Value("${test.author}")
    private String author;

    @Test
    void testProperties() {
        Assertions.assertEquals("Test Value", msg);
    }

    @Test
    void testAuthor() {
        Assertions.assertEquals("ijunfu", author);
    }
}
