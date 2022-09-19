package com.makingapp.mercury.jpa.configuration;


import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "readWriteEntityManagerFactory",
        transactionManagerRef = "readWriteTransactionManager",
    basePackages = {"com.makingapp.mercury.jpa.repository",
            "com.makingapp.mercury.jpa.adapters",
            "com.makingapp.mercury.jpa.entities",
            "com.makingapp.mercury.jpa.mapper",

    }
)
public class ReadWriteDataSourceConfig {
    @Primary
    @Bean(name = "getReadWriteDataSource")
    public DataSource getDataSource(Environment env) {

        HikariConfig config = new HikariConfig();
        config.setDriverClassName(env.getProperty("datasource.readwrite.driver-class-name"));
        config.setJdbcUrl(env.getProperty("datasource.readwrite.url"));
        config.setUsername(env.getProperty("datasource.readwrite.username"));
        config.setPassword(env.getProperty("datasource.readwrite.password"));
        config.addDataSourceProperty("connectionTimeout",
                env.getProperty("datasource.readwrite.hikari.data-source-properties.connectionTimeout"));
        config.addDataSourceProperty("minimumIdle",
                env.getProperty("datasource.readwrite.hikari.data-source-properties.minimumIdle"));
        config.addDataSourceProperty("maximumPoolSize",
                env.getProperty("datasource.readwrite.hikari.data-source-properties.maximumPoolSize"));
        config.addDataSourceProperty("cachePrepStmts",
                env.getProperty("datasource.readwrite.hikari.data-source-properties.cachePrepStmts"));
        config.addDataSourceProperty("prepStmtCacheSize",
                env.getProperty("datasource.readwrite.hikari.data-source-properties.prepStmtCacheSize"));
        config.addDataSourceProperty("prepStmtCacheSqlLimit",
                env.getProperty("datasource.readwrite.hikari.data-source-properties.prepStmtCacheSqlLimit"));
        config.addDataSourceProperty("useServerPrepStmts",
                env.getProperty("datasource.readwrite.hikari.data-source-properties.useServerPrepStmts"));
        config.setReadOnly(false);
        return new HikariDataSource(config);

    }

    @Primary
    @Bean(name = "readWriteEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean readWriteEntityManagerFactory(EntityManagerFactoryBuilder builder,
                                                                                @Qualifier("getReadWriteDataSource") DataSource dataSource) {
        return
                builder
                        .dataSource(dataSource)
                        .packages("com.makingapp.mercury.jpa.entities")
                        .persistenceUnit("readWrite")
                        .build();
    }

    @Primary
    @Bean(name = "readWriteTransactionManager")
    public PlatformTransactionManager readWriteTransactionManager(
            @Qualifier("readWriteEntityManagerFactory") EntityManagerFactory readWriteEntityManagerFactory) {
        return new JpaTransactionManager(readWriteEntityManagerFactory);
    }
}
