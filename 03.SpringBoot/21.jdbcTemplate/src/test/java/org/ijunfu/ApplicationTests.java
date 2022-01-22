package org.ijunfu;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@SpringBootTest
class ApplicationTests {

    @Autowired
    DataSource dataSource;

    /**
     *
     * @Title       datasource
     * @Description 测试数据源
     *
     * @author      weijunfu<ijunfu@163.com>
     * @date        2022/01/23 00:27
     * @version     1.0.0
     * @param
     * @Return      void
     */
    @Test
    void datasource() throws SQLException {
        Connection conn = dataSource.getConnection();
        System.out.println(conn);
        conn.close();
    }

}
