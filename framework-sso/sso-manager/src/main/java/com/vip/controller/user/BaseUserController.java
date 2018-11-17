package com.vip.controller.user;

import com.vip.base.ReqParam;
import com.vip.base.Result;
import com.vip.code.CodeEnum;
import com.vip.common.UserCodeEnum;
import com.vip.common.UserResult;
import com.vip.request.user.UserLoginPasswdAccountReq;
import com.vip.request.user.UserRegisterPhoneReq;
import com.vip.request.user.base.BaseUserAccountReq;
import com.vip.service.user.BaseUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
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
@Api(value = "用户基础信息API")
public class BaseUserController {

  @Autowired
  private BaseUserService userService;

  /**
   * @Description 账号登录
   * @author GorgeousNi on 2018/11/14 8:56 PM
   */
  @RequestMapping(value = "login_passwd", method = RequestMethod.POST)
  @ResponseBody
  @ApiOperation(value = "账号密码登录接口", notes = "账号密码登录，账号包含手机号、用户名、邮箱，登录成功后返回用户token")
  public Result loginPasswd(
      @ApiParam(required = true, value = "用户登录请求参数")
      @RequestBody ReqParam<UserLoginPasswdAccountReq> reqParam) {
    if (reqParam == null) {
      return Result.failure(CodeEnum.ERROR_HTTP);
    }
    UserLoginPasswdAccountReq accountReq = reqParam.getSendData();
    if (StringUtils.isBlank(accountReq.getAccountName())) {
      return UserResult.failure(UserCodeEnum.EMPTY_USER_NAME);
    }
    if (StringUtils.isBlank(accountReq.getLoginPasswd())) {
      return UserResult.failure(UserCodeEnum.EMPTY_USER_PASSWD);
    }
    return userService.loginPasswd(accountReq);
  }

  /**
   * @Description 账号是否存在
   * @author GorgeousNi on 2018/11/14 9:46 PM
   */
  @RequestMapping(value = "check_user_exist", method = RequestMethod.POST)
  @ResponseBody
  @ApiOperation(value = "根据账号判断用户是否存在接口",notes = "若账号不存在返回成功，否则返回失败")
  public Result checkUserExist(
      @ApiParam(required = true, value = "用户账号请求参数")
      @RequestBody ReqParam<BaseUserAccountReq> reqParam) {
    if (reqParam == null) {
      return Result.failure(CodeEnum.ERROR_HTTP);
    }
    BaseUserAccountReq accountReq = reqParam.getSendData();
    if (StringUtils.isBlank(accountReq.getAccountName())) {
      return UserResult.failure(UserCodeEnum.EMPTY_USER_PHONE);
    }
    if (userService.checkUserExist(accountReq.getAccountName())) {
      return UserResult.failure(UserCodeEnum.ACCOUNT_IS_EXIST);
    }
    return Result.success();
  }


  /**
   * @Description 手机号注册
   * @author GorgeousNi on 2018/11/14 9:37 PM
   */
  @RequestMapping(value = "register", method = RequestMethod.POST)
  @ResponseBody
  @ApiOperation(value = "用户手机号注册接口",notes = "手机号注册")
  public Result register(
      @ApiParam(required = true, value = "用户注册请求参数")
      @RequestBody ReqParam<UserRegisterPhoneReq> reqParam) {
    if (reqParam == null) {
      return Result.failure(CodeEnum.ERROR_HTTP);
    }
    UserRegisterPhoneReq accountReq = reqParam.getSendData();
    if (StringUtils.isBlank(accountReq.getMobilePhone())) {
      return UserResult.failure(UserCodeEnum.EMPTY_USER_PHONE);
    }
    /**
     * 判断账号是否存在
     */
    if (userService.checkUserExist(accountReq.getMobilePhone())) {
      return UserResult.failure(UserCodeEnum.ACCOUNT_IS_EXIST);
    }
    if (StringUtils.isBlank(accountReq.getVerifyCode())) {
      return UserResult.failure(UserCodeEnum.EMPTY_VERIFY_CODE);
    }
    if (StringUtils.isBlank(accountReq.getLoginPasswd())) {
      return UserResult.failure(UserCodeEnum.EMPTY_USER_PASSWD);
    }
    return userService.register(accountReq);
  }

}
