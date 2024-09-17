package com.mvc.homework.config;

import java.util.Properties;

import org.hibernate.dialect.MySQL5Dialect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class HibernateConfig {

//	@Autowired
//	private Environment environment;
	
    @Bean
    public DriverManagerDataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/bulletin_board?serverTimezone=Asia/Taipei");
        dataSource.setUsername("root");
        dataSource.setPassword("root");        
        return dataSource;
    }
    
	@Bean
    public LocalSessionFactoryBean sessionFactory() {
	    LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();
	    factoryBean.setDataSource(dataSource());
	    factoryBean.setPackagesToScan("com.mvc.homework.model");
	    factoryBean.setHibernateProperties(additionalProperties());
	    return factoryBean;
    }

	private Properties additionalProperties() {
		Properties properties = new Properties();
		
		properties.put("hibernate.dialect", MySQL5Dialect.class.getName());
//		properties.put("hibernate.show_sql", Boolean.TRUE);
//		properties.put("hibernate.format_sql", Boolean.TRUE);
//		properties.put("use_sql_comments", Boolean.TRUE);
		properties.put("default_batch_fetch_size", 10);
		properties.put("hibernate.hbm2ddl.auto", "update");
		
		return properties;
	}

	@Bean
	public HibernateTransactionManager transactionManager() {	
		HibernateTransactionManager txManager = new HibernateTransactionManager();
		txManager.setSessionFactory(sessionFactory().getObject());
		return txManager;
	}

}
