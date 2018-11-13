//
//package com.vip.config;
//
//import org.mybatis.spring.mapper.MapperScannerConfigurer;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
///**
//* @Description 扫描Mapper，并注入SqlSessionFactory工厂类
//* @author GorgeousNi on 2018/11/13 9:02 PM
//*/
//@Configuration
//public class MapperConfig
//{
//	private static final String BASE_PACK = "com.vip.dao.*";
//
//	@Bean
//	public MapperScannerConfigurer mapperScannerConfigurer ()
//	{
//		MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer ();
//		mapperScannerConfigurer.setSqlSessionFactoryBeanName ("sqlSessionFactory");
//		mapperScannerConfigurer.setBasePackage (BASE_PACK);
//		return mapperScannerConfigurer;
//	}
//}
