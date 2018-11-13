package com.vip.controller.user;

import com.vip.base.ReqParam;
import com.vip.base.Result;
import com.vip.code.CodeEnum;
import com.vip.request.user.UserLoginPasswdAccountReq;
import com.vip.service.user.BaseUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户注册登录
 *
 * @author GorgeousNi Created in 2018/11/13 5:48 PM
 * @Description:
 */
@RestController
@RequestMapping(value = "/user/base/")
public class BaseUserController {

  @Autowired
  private BaseUserService userService;

  @RequestMapping(value = "login_passwd", method = RequestMethod.POST)
  @ResponseBody
  public Result login(
      @RequestBody ReqParam<UserLoginPasswdAccountReq> reqParam) {
    if (reqParam == null) {
      return Result.failure(CodeEnum.ERROR_HTTP);
    }
    UserLoginPasswdAccountReq accountReq = reqParam.getSendData();
    return userService.loginPasswd(accountReq);
  }


}
