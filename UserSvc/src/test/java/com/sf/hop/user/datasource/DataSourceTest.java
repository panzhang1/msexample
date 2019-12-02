package com.sf.hop.user.datasource;

import javax.sql.DataSource;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.zaxxer.hikari.HikariDataSource;


@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles({"dev"})
public class DataSourceTest {

    @Autowired
    private DataSource dataSource;

    @Test
    public void testDataSourceConfig() {
        HikariDataSource hikari = (HikariDataSource)dataSource;
        Assert.assertEquals(21000, hikari.getConnectionTimeout());
        Assert.assertEquals(15, hikari.getMaximumPoolSize());
    }
}