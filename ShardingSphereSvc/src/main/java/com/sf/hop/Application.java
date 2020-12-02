package com.sf.hop;

import com.sf.hop.config.YamlDataSourceFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

/**
 * It can only scan the component under this package
 *
 */
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    @Primary
    DataSource dataSource() {
        try {
            DataSource dataSource = YamlDataSourceFactory.newInstance();
            return dataSource;
        } catch(Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}