package com.vip.config;

import java.util.ArrayList;
import java.util.List;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author GorgeousNi on 2018/11/17 10:29 PM
 * @Description 接口工具Swagger配置
 */
@Configuration
@EnableSwagger2
public class Swagger2 {

  @Bean
  public Docket createRestApi() {
    ParameterBuilder paramBuilder = new ParameterBuilder();
    paramBuilder.name("authorization")
        .description("令牌凭证")
        .modelRef(new ModelRef("string"))
        .parameterType("header")
        .required(false)
        .build();
    List<Parameter> paramList = new ArrayList<Parameter>();
    paramList.add(paramBuilder.build());
    return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo())
        .useDefaultResponseMessages(false)
        .forCodeGeneration(true)
        .globalOperationParameters(paramList)
        // .pathMapping("/")// auth，最终调用接口后会和paths拼接在一起
        .select()
        .apis(RequestHandlerSelectors.basePackage("com.vip.controller"))
        .paths(PathSelectors.any()).build();
  }

  private ApiInfo apiInfo() {
    return new ApiInfoBuilder()
        .title("唯品会接口平台")
        .description("如果和接口文档不一致，请以此API为准")
        .termsOfServiceUrl("http://GorgeousNi.com/")
        .contact("GorgeousNi").version("1.0.0").build();
  }

}
