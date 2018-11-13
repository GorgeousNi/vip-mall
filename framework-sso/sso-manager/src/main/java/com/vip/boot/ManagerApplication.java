package com.vip.boot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author GorgeousNi Created in 2018/11/13 9:35 AM
 * @Description:
 */
@SpringBootApplication
@ComponentScan("com.vip.*")
@MapperScan("com.vip.dao.*") //mapper文件
@EnableTransactionManagement
@ImportResource(locations = "classpath:spring.xml")
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class})
public class ManagerApplication {

  public static void main(String[] args) {
    System.out.println("ManagerApplication startup...");
    SpringApplication.run(ManagerApplication.class, args);
    System.out.println("ManagerApplication startup successful...");
  }
}