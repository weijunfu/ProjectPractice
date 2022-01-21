package org.ijunfu;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ApplicationTests {

    @Value("${test.msg}")
    private String msg;

    @Test
    void testProperties() {
        Assertions.assertEquals("Test Value", msg);
    }

}
