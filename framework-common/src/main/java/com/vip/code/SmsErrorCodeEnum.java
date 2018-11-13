package com.vip.code;

/**
 * @author GorgeousNi Created in 2018/10/19 下午4:54
 * @Description:
 */
public enum SmsErrorCodeEnum {

  SMS_PHONE_NOTFOUND("SMS0001", "手机号码不能为空!"),
  SMS_CONTENT_NOTFOUND("SMS0002", "短信内容不能为空!"),
  SMS_SIGN_NOTFOUND("SMS0003", "短信签名不能为空!"),
  SMS_SEND_ERROR("SMS0004", "通知类短信发送异常!"),
  SMS_TYPE_ERROR("SMS0005", "短信类型为空或有误!"),
  SMS_SEND_RANDOM_ERROR("SMS0006", "短信验证码发送异常!"),
  SMS_SEND_MARKET_ERROR("SMS0007", "营销类短信发送异常!"),
  SMS_SEND_XML_ERROR("SMS0008", "亿美短信API接口返回参数解析异常!"),
  SMS_SAVE_CODE_ERROR("SMS0009", "短信验证码保存异常!"),
  SMS_VERIFY_CODE_ERROR("SMS0010", "短信验证码错误!"),
  SMS_VERIFY_CODE_EXPIRE("SMS0011", "短信验证码已过期!"),
  SMS_VERIFY_CODE_NOTFOUND("SMS0012", "验证码不能为空!"),

  SMS_SECURITY_ERROR("SMS00020", "加密异常!"),
  SMS_EMAY_REQUEST_ERROR("SMS00021", "请求发送短信失败!"),
  SMS_SER_SEND_ERROR("SMS00022", "单条短信发送异常!"),;


  private String code;
  private String msg;

  SmsErrorCodeEnum(String code, String msg) {
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
