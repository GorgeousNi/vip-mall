package com.vip.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


/**
 * @author GorgeousNi on 2018/11/17 6:58 PM
 * @Description 配置拦截器
 */
@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {

  @Autowired
  private AuthInterceptor authInterceptor;

  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    registry.addInterceptor(authInterceptor)
        .addPathPatterns("/**")
        .excludePathPatterns("/configuration/**")
        .excludePathPatterns("/swagger-resources/**")
        .excludePathPatterns("/v2/**")
        .excludePathPatterns("/user/base/register")
        .excludePathPatterns("/user/base/login_passwd")
        .addPathPatterns("/user/base/check_user_exist");
    super.addInterceptors(registry);
  }
}
