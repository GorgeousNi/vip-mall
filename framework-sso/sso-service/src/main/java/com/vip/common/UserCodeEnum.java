package com.vip.common;


/**
 * 用户状态信息类
 *
 * @author GorgeousNi Created in 2018/11/13 3:16 PM
 * @Description:
 */
public enum  UserCodeEnum{

  ERROR_USER_NAME("USER00001", "用户名不存在!"),
  ERROR_USER_PASSWD("USER00002", "密码不正确!"),
  ;

  private String code;
  private String msg;

  UserCodeEnum(String code, String msg) {
    this.code = code;
    this.msg = msg;
  }


  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public String getMsg() {
    return msg;
  }

  public void setMsg(String msg) {
    this.msg = msg;
  }
}
