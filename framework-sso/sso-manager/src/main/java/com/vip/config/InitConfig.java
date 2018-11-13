//
//package com.vip.config;
//
//import com.alibaba.druid.pool.DruidDataSource;
//import org.apache.ibatis.session.SqlSessionFactory;
//import org.mybatis.spring.SqlSessionFactoryBean;
//import org.mybatis.spring.SqlSessionTemplate;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
//import org.springframework.core.io.support.ResourcePatternResolver;
//
///**
//* @Description mybatis扫描路径配置
//* @author GorgeousNi on 2018/11/13 8:59 PM
//*/
//@Configuration
//public class InitConfig
//{
//	private static final Logger logger = LoggerFactory.getLogger (InitConfig.class);
//
//	/**
//	 * 实体类包位置
//	 */
//	private static final String MODEL_PACKAGE_PATH = "com.vip.model.*";
//
//	/**
//	 * mybatis映射文件路径
//	 */
//	private static final String MAPPER_PATH = "classpath:mappers/*.xml";
//
//	@Autowired
//	private DruidDataSource dataSource;
//
//	@Bean (name = "sqlSessionFactory")
//	public SqlSessionFactory sqlSessionFactory ()
//	{
//		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean ();
//		sqlSessionFactoryBean.setDataSource (dataSource);
//
//		/**
//		 * 扫描实体类包
//		 */
//		sqlSessionFactoryBean.setTypeAliasesPackage (MODEL_PACKAGE_PATH);
//
//		ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver ();
//
//		try
//		{
//			/*扫描mybatis配置文件*/
//			sqlSessionFactoryBean.setMapperLocations (resolver.getResources (MAPPER_PATH));
//			return sqlSessionFactoryBean.getObject ();
//		}
//		catch (Exception e)
//		{
//			logger.error ("init database error.", e);
//			//throw new Exception ("999999", "init database failed.");
//			return null;
//		}
//	}
//
//	@Bean
//	public SqlSessionTemplate sqlSessionTemplate (SqlSessionFactory sqlSessionFactory)
//	{
//		return new SqlSessionTemplate (sqlSessionFactory);
//	}
//
//}
