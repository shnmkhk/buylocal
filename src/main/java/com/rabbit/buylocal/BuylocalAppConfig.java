package com.rabbit.buylocal;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
@PropertySource("classpath:application.properties")
public class BuylocalAppConfig {
    @Value("${spring.datasource.url:jdbc:h2:mem:testdb;MODE=LEGACY;DB_CLOSE_ON_EXIT=true;DB_CLOSE_DELAY=-1}")
    private String dbUrl;
    @Value("${spring.datasource.username:sa}")
    private String dbUsername;
    @Value("${spring.datasource.password:}")
    private String dbPassword;
    @Value("${spring.datasource.driver-class-name:org.h2.Driver}")
    private String dbDriverClassname;

    @Bean(destroyMethod = "close")
    public DataSource dataSource() {

        HikariConfig hikariConfig = new HikariConfig();
        hikariConfig.setDriverClassName(dbDriverClassname);
        hikariConfig.setJdbcUrl(dbUrl);
        hikariConfig.setUsername(dbUsername);
        hikariConfig.setPassword(dbPassword);

        hikariConfig.setMaximumPoolSize(5);
        hikariConfig.setConnectionTestQuery("SELECT 1");
        hikariConfig.setPoolName("springHikariCP");

        hikariConfig.addDataSourceProperty("dataSource.cachePrepStmts", "true");
        hikariConfig.addDataSourceProperty("dataSource.prepStmtCacheSize", "250");
        hikariConfig.addDataSourceProperty("dataSource.prepStmtCacheSqlLimit", "2048");
        hikariConfig.addDataSourceProperty("dataSource.useServerPrepStmts", "true");

        HikariDataSource dataSource = new HikariDataSource(hikariConfig);

        return dataSource;
    }
}
