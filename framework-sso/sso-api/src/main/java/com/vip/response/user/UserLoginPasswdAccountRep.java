package com.vip.response.user;

import com.vip.base.BaseModel;
import lombok.Getter;
import lombok.Setter;

/**
 * 登录返回参数
 *
 * @author GorgeousNi Created in 2018/11/14 10:13 AM
 * @Description:
 */
@Setter
@Getter
public class UserLoginPasswdAccountRep implements BaseModel {

  /**
   * 用户信息token
   */
  private String authorization;

}
