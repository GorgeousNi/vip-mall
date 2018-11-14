package com.vip.service.user;

import com.vip.base.Result;
import com.vip.request.user.UserLoginPasswdAccountReq;
import com.vip.request.user.UserRegisterPhoneReq;
import com.vip.request.user.base.BaseUserAccountReq;

/**
 * 用户登录注册服务
 *
 * @author GorgeousNi Created in 2018/11/13 10:13 AM
 * @Description:
 */
public interface BaseUserService {

  /**
   * @Description 用户账号密码登录
   * @author GorgeousNi on 2018/11/13 2:19 PM
   */
  Result loginPasswd(UserLoginPasswdAccountReq loginReq);

  /**
   * @Description 手机号注册
   * @author GorgeousNi on 2018/11/13 2:19 PM
   */
  Result register(UserRegisterPhoneReq registerReq);

  /**
  * @Description 根据账号判断账号是否存在
  * @author GorgeousNi on 2018/11/14 9:40 PM 
  */
  boolean checkUserExist(String accountName);

  /**
   * @Description 根据账号获取用户信息
   * @author GorgeousNi on 2018/11/13 2:19 PM
   */
  Result getUserByAccount(BaseUserAccountReq accountReq);


}
