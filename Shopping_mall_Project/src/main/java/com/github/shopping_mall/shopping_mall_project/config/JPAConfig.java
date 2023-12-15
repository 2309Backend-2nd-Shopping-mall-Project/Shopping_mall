package com.github.shopping_mall.shopping_mall_project.config;



import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableJpaRepositories(
        basePackages = {"com.github.shopping_mall.shopping_mall_project.repository.Test"},
        entityManagerFactoryRef = "entityManagerFactoryBean1",
        transactionManagerRef = "tmJpa1"
)
public class JPAConfig {

    //Entity Manager
    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean1(@Qualifier("dataSource1")DataSource dataSource){
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(dataSource);
        em.setPackagesToScan("com.github.shopping_mall.shopping_mall_project.repository.Test");

        JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);

        Map<String, Object> properties = new HashMap<>();
        properties.put("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");
        properties.put("hibernate.format_sql", "true");
        properties.put("hibernate.use_sql_comment", "true");

        em.setJpaPropertyMap(properties);
        return em;
    }

    //Transaction Manager
    @Bean(name = "tmJpa1")
    public PlatformTransactionManager transactionManager1(@Qualifier("dataSource1") DataSource dataSource){
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactoryBean1(dataSource).getObject());
        return transactionManager;
    }
}
