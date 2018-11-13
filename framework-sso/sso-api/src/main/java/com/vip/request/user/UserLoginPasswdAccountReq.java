package com.vip.request.user;

import com.vip.request.user.base.BaseUserAccountReq;
import lombok.Getter;
import lombok.Setter;

/**
 * 用户名密码登录
 *
 * @author GorgeousNi Created in 2018/11/13 10:43 AM
 * @Description:
 */
@Setter
@Getter
public class UserLoginPasswdAccountReq extends BaseUserAccountReq {

  /**
   * 登录密码
   */
  private String loginPasswd;

}
