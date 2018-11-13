package com.vip.code;

/**
 * 基础信息/服务信息
 *
 * @author GorgeousNi on 2018/11/13 10:20 AM
 * @Description 基础错误码定义
 */
public enum CodeEnum {

  SUCCESS("200", "操作成功!"),
  ERROR_SOURCE("400", "请求来源参数不能为空"),
  ERROR_SIGN("401", "签名参数不能为空"),
  ERROR_TOKEN("402", "TOKEN不能为空"),
  PARAMETER_ERROR("403", "参数不合法"),
  ERROR_NOTFOUND("404", "查询为空"),
  ERROR_HTTP("414", "请求出错"),
  ERROR("500", "服务异常，请稍后再试"),
  ERROR_EXCHANGE("501", "转换异常，请稍后再试");


  private String code;
  private String msg;

  CodeEnum(String code, String msg) {
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