package com.cobiztech.conference_booking.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * Customize and create configuration changes in Persistence-tier
 * Note:
 * Spring-Boot scans for @Bean in spring context and replaces them.
 */

@Configuration
public class PersistenceConfiguration {
    // Avoid hard-coding sensitive-data e.g passwords into configuration files.

    // dependency Injection - inject properties from Environment variables.
    @Value("${DB_URL}")
    private String DB_URL;

    @Value("${DB_USERNAME}")
    private String DB_USERNAME;

    @Value("${DB_PASSWORD}")
    private String DB_PASSWORD;

    @Bean
    public DataSource dataSource() {
        DataSourceBuilder builder = DataSourceBuilder.create();
        builder.url(DB_URL);
        builder.password(DB_PASSWORD);
        builder.username(DB_USERNAME);
        System.out.println("---------My custom datasource :: has been initialized and set.  --- "
                + DB_URL + " --- "
                + DB_USERNAME + "  ----"
                + DB_PASSWORD);
        return builder.build();
    }

}
