package com.javasampleapproach.security.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

/**
 * Created by Pablo on 26/09/2016.
 */
@Configuration
@EnableAutoConfiguration
@EnableJpaRepositories(basePackages = {"com.javasampleapproach.security.repository"})
public class DatabaseConfiguration {

    @Value("${spring.jpa.show-sql:false}")
    private String showSql;

    @Value("${spring.jpa.properties.hibernate.dialect}")
    private String dialect;

    @Primary
    @Bean(name = "dataSource")
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }

    // All JPA Repositories
    @Bean
    public EntityManagerFactory entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(this.dataSource());
        em.setPackagesToScan("com.javasampleapproach.security.entity");

        JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);
        em.setJpaProperties(this.additionalProperties());
        em.afterPropertiesSet();

        return em.getObject();
    }

    Properties additionalProperties() {
        Properties properties = new Properties();
        properties.setProperty("hibernate.hbm2ddl.auto", "update");
        properties.setProperty("hibernate.dialect", dialect);
        properties.setProperty("hibernate.archive.autodetection", "class");
        properties.setProperty("hibernate.show_sql", showSql);
        properties.setProperty("hibernate.format_sql", "true");
        properties.setProperty("hibernate.connection.autocommit", "true");

        return properties;
    }
}
