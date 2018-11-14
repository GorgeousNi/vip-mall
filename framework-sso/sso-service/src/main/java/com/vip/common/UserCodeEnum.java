package com.vip.common;


/**
 * 用户状态信息类
 *
 * @author GorgeousNi Created in 2018/11/13 3:16 PM
 * @Description:
 */
public enum  UserCodeEnum{

  EMPTY_USER_NAME("USER00401", "用户名不能为空!"),
  EMPTY_USER_PASSWD("USER00402", "密码不能为空!"),
  EMPTY_USER_PHONE("USER00043", "手机号不能为空!"),
  EMPTY_VERIFY_CODE("USER00404", "验证码不能为空!"),

  ERROR_USER_NAME("USER00410", "用户名不存在!"),
  ERROR_USER_PASSWD("USER00411", "密码不正确!"),


  ACCOUNT_IS_EXIST("USER00610", "该账号存在!"),
  ACCOUNT_NOT_EXIST("USER00611", "该账号不存在!"),

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
