//
//package com.vip.config;
//
//import com.alibaba.druid.pool.DruidDataSource;
//import lombok.Getter;
//import lombok.Setter;
//import lombok.ToString;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//
///**
//* @Description 数据源配置
//* @author GorgeousNi on 2018/11/13 9:01 PM
//*/
//@Setter
//@Getter
//@ToString
//@Configuration
////@ConfigurationProperties (prefix = "spring.datasource")
//public class DataSource
//{
//	private String url;
//
//	private String username;
//
//	private String password;
//
//	private String driverClassName;
//
//	private String maxActive;
//
//	private String initialSize;
//
//	private String maxWait;
//
//	private String minIdle;
//
//	private String timeBetweenEvictionRunsMillis;
//
//	private String minEvictableIdleTimeMillis;
//
//	private Boolean testWhileIdle;
//
//	private String validationQuery;
//
//	@Bean
//	public DruidDataSource druidDataSource ()
//	{
//		DruidDataSource dataSource = new DruidDataSource ();
//		dataSource.setUrl (url);
//		dataSource.setDriverClassName (driverClassName);
//		dataSource.setPassword (password);
//		dataSource.setUsername (username);
//		dataSource.setMaxActive (Integer.valueOf (maxActive));
//		dataSource.setMinIdle (Integer.valueOf (minIdle));
//		dataSource.setTimeBetweenEvictionRunsMillis (new Long (timeBetweenEvictionRunsMillis));
//		dataSource.setMinEvictableIdleTimeMillis (new Long (minEvictableIdleTimeMillis));
//		dataSource.setTestWhileIdle (testWhileIdle);
//		dataSource.setValidationQuery (validationQuery);
//		return dataSource;
//	}
//}
