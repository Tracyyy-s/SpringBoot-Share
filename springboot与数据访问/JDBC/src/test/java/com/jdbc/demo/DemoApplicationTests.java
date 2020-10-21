package com.jdbc.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@SpringBootTest
class DemoApplicationTests {

//    自动注入数据源
    @Autowired
    DataSource dataSource;

    @Test
    void contextLoads() throws SQLException {
//        com.zaxxer.hikari.HikariDataSource
        System.out.println(dataSource.getClass());

//        从数据源中获取一条链接
        Connection connection = dataSource.getConnection();
//        HikariProxyConnection@713707020 wrapping com.mysql.cj.jdbc.ConnectionImpl@26c89563
        System.out.println(connection);
        connection.close();
    }
}
