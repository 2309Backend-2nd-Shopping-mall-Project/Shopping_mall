package com.github.shopping_mall.shopping_mall_project.config;


import com.github.shopping_mall.shopping_mall_project.properties.DataSourceProperties;
import lombok.RequiredArgsConstructor;


import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

@Configuration
@EnableConfigurationProperties(DataSourceProperties.class)
@RequiredArgsConstructor
public class JdbcConfig {
    private final DataSourceProperties dataSourceProperties;
    //Jdbc 관련 빈 등록

    @Bean
    public DataSource dataSource1(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUsername(dataSourceProperties.getUsername());
        dataSource.setPassword(dataSourceProperties.getPassword());
        dataSource.setDriverClassName(" org.mariadb.jdbc.Driver");
        dataSource.setUrl("jdbc:mariadb://project2.cehckoacemxp.ap-northeast-2.rds.amazonaws.com:3306/Project2?useUnicode=true&characterEncoding=UTF-8");
        return dataSource;
    }



    @Bean
    public JdbcTemplate jdbcTemplate1(){
        return new JdbcTemplate(dataSource1());
    }


    @Bean(name="tm1")
    public PlatformTransactionManager transactionManager1() { return new DataSourceTransactionManager(dataSource1());}


}