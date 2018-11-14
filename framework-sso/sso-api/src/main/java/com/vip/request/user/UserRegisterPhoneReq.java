package com.vip.request.user;


import com.vip.request.user.base.BaseUserPhoneReq;
import lombok.Getter;
import lombok.Setter;

/**
 * 手机号密码注册
 *
 * @author GorgeousNi Created in 2018/11/13 10:28 AM
 * @Description:
 */
@Setter
@Getter
public class UserRegisterPhoneReq extends BaseUserPhoneReq {

  /**
   * 验证码
   */
  private String verifyCode;

  /**
   * 登录密码
   */
  private String loginPasswd;


}
