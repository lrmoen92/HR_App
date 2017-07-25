package com.astontech.hr;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * Created by Logan.Moen on 7/7/2017.
 */
@SpringBootApplication
public class Application {

    @Value("${spring.datasource.url}")
    private String datasourceURL;

    @Value("${spring.datasource.username}")
    private String datasourceUsername;

    @Value("${spring.datasource.password}")
    private String datasourcePassword;

    @Value("${spring.datasource.driverClassName}")
    private String datasourceDriverClassName;

    @Bean
    public DataSource dataSource(){
        DataSource ds = new DataSource();
        ds.setDriverClassName(datasourceDriverClassName);
        ds.setUrl(datasourceURL);
        ds.setUsername(datasourceUsername);
        ds.setPassword(datasourcePassword);
        return ds;
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
