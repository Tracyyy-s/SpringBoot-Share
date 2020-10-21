package com.tracy.springboot;

import com.alibaba.druid.pool.DruidDataSource;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

/**
 * @author Tracy
 * @date 2020/10/11 15:13
 */
@SpringBootTest
public class ConfigTest {

    @Autowired
    ApplicationContext ioc;

    @Test
    public void testConf1() {
        System.out.println(ioc.containsBean("dataSource"));

        DruidDataSource bean = ioc.getBean(DruidDataSource.class);

        System.out.println(bean.getUsername() + " " + bean.getPassword() + " " + bean.getDriverClassName());

//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        System.out.println(bean.getUsername() + " " + bean.getPassword() + " " + bean.getDriverClassName());
    }

}
