//package com.vip.user.service;
//
//import com.alibaba.fastjson.JSONObject;
//import com.vip.base.Result;
//import com.vip.request.user.UserLoginPasswdAccountReq;
//import com.vip.service.user.BaseUserService;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.SpringApplicationConfiguration;
//import org.springframework.test.context.junit4.SpringRunner;
//
///**
// * @author GorgeousNi Created in 2018/11/13 6:25 PM
// * @Description:
// */
//@RunWith(SpringRunner.class)
//@SpringApplicationConfiguration(classes = App.class)
//public class BaseUserServiceTest {
//
//  @Autowired
//  private BaseUserService baseUserService;
//
//  @Test
//  public void loginPasswd() {
//
//    System.out.println("---- 单元测试开始 ----");
//    UserLoginPasswdAccountReq accountReq = new UserLoginPasswdAccountReq();
//    accountReq.setAccountName("18819176050");
//    accountReq.setLoginPasswd("123456");
//    Result result = baseUserService.loginPasswd(accountReq);
//
//    System.out.println(JSONObject.toJSON(result));
//  }
//}
