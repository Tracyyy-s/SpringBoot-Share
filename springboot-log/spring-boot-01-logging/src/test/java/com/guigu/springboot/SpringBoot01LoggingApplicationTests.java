package com.guigu.springboot;

import com.guigu.springboot.bean.Person;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
class SpringBoot01LoggingApplicationTests {

    @Autowired
    Person person;

    //记录器
    Logger logger = LoggerFactory.getLogger(getClass());
    @Test
    public void contextLoads() {

        System.out.println(person);

        //System.out.println();

        Logger logger = LoggerFactory.getLogger("123");
        //日志的级别；
        //由低到高   error<debug<info<warn<trace
        //可以调整输出的日志级别；日志就只会在这个级别以以后的高级别生效
        this.logger.trace("这是trace日志...");//跟踪轨迹
        this.logger.debug("这是debug日志...");//调试
        //SpringBoot默认给我们使用的是info级别的，没有指定级别的就用SpringBoot默认规定的级别；root级别
        this.logger.info("这是info日志...");//自定义日志
        this.logger.warn("这是warn日志...");//警告
        this.logger.error("这是error日志...");//错误

    }

}
