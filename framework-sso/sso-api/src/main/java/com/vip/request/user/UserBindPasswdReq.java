package com.vip.request.user;

import com.vip.request.user.base.BaseUserTokenReq;
import lombok.Getter;
import lombok.Setter;

/**
 * 重置密码
 *
 * @author GorgeousNi Created in 2018/11/13 10:55 AM
 * @Description:
 */
@Setter
@Getter
public class UserBindPasswdReq extends BaseUserTokenReq {

  /**
   * 新密码
   */
  private String newPasswd;

  /**
   * 旧密码
   */
  private String oldPasswd;


}
