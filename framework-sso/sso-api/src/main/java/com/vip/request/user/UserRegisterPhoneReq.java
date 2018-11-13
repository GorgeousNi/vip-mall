package com.vip.request.user;


import com.vip.base.BaseModel;
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
public class UserRegisterPhoneReq implements BaseModel {

  /**
   * 手机号
   */
  private String mobilePhone;

  /**
   * 验证码
   */
  private String verifyCode;

  /**
   * 登录密码
   */
  private String loginPasswd;


}
