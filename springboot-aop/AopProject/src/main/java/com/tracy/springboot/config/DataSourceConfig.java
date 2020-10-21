package com.tracy.springboot.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

/**
 * @author Tracy
 * @date 2020/10/11 15:08
 */
@Component
@Configuration
@PropertySource(value = {"classpath:db.properties"})
public class DataSourceConfig {

    @Bean
    @ConfigurationProperties(prefix = "db")
    public DataSource dataSource() {
        return new DruidDataSource();
    }

}
