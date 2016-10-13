package com.qr.qradmin.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.dao.support.PersistenceExceptionTranslator;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.hibernate4.HibernateExceptionTranslator;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.support.TransactionTemplate;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(value = {"com.qr.qradmin.dao"})
public class DatasourceConfig {

    @Bean(destroyMethod = "close")
    public DataSource dataSource(Environment environment) throws Exception {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setDriverClass(environment.getProperty("datasource.databaseDriver"));
        dataSource.setJdbcUrl(environment.getProperty("datasource.url"));
        dataSource.setUser(environment.getProperty("datasource.username"));
        dataSource.setPassword(environment.getProperty("datasource.password"));
        dataSource.setInitialPoolSize(5);
        dataSource.setMaxPoolSize(50);
        dataSource.setMaxConnectionAge(3600);
        dataSource.setMaxIdleTime(60);
        dataSource.setIdleConnectionTestPeriod(60);
        dataSource.setPreferredTestQuery("select * from dual;");
        dataSource.setMaxStatements(0);
        dataSource.setMaxStatementsPerConnection(100);

        return dataSource;
    }

    @Bean
    public EntityManagerFactory entityManagerFactory(Environment environment) throws Exception {
        LocalContainerEntityManagerFactoryBean entityManagerFactory = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactory.setDataSource(dataSource(environment));
        entityManagerFactory.setJpaVendorAdapter(vendorAdapter(environment));
        entityManagerFactory.setPackagesToScan("ru.qrhandshake.qrpos.domain");
        entityManagerFactory.setJpaProperties(jpaProperties(environment));
        entityManagerFactory.afterPropertiesSet();
        return entityManagerFactory.getObject();
    }

    @Bean
    public Properties jpaProperties(Environment environment) {
        Properties properties = new Properties();
        properties.put("hibernate.temp.use_jdbc_metadata_defaults", "false");
        properties.put("hibernate.jdbc.batch_size", 100);
        if ( environment.containsProperty("hibernate.hbm2ddl.auto") ) {
            properties.put("hibernate.hbm2ddl.auto", environment.getProperty("hibernate.hbm2ddl.auto"));
        }
        if ( environment.containsProperty("hibernate.hbm2ddl.import_files") ) {
            properties.put("hibernate.hbm2ddl.import_files", environment.getProperty("hibernate.hbm2ddl.import_files"));
        }
        properties.put("hibernate.connection.CharSet","utf8");
        properties.put("hibernate.connection.characterEncoding","utf8");
        properties.put("hibernate.connection.useUnicode","true");
        return properties;
    }


    @Bean
    public JpaVendorAdapter vendorAdapter(Environment environment) {
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        vendorAdapter.setShowSql(environment.getProperty("datasource.showSql",Boolean.class));
        vendorAdapter.setDatabasePlatform(environment.getRequiredProperty("datasource.dialect"));
        return vendorAdapter;
    }

    @Bean
    public TransactionTemplate transactionTemplate(Environment environment) throws Exception {
        return new TransactionTemplate(transactionManager(environment));
    }

    @Bean
    public PlatformTransactionManager transactionManager(Environment environment) throws Exception {
        JpaTransactionManager transactionManager = new JpaTransactionManager(entityManagerFactory(environment));
        return transactionManager;
    }

    @Bean
    public PersistenceExceptionTranslator exceptionTranslation() {
        return new HibernateExceptionTranslator();
    }

    @Bean
    public JdbcTemplate jdbcTemplate(Environment environment) throws Exception {
        return new JdbcTemplate(dataSource(environment));
    }

}
