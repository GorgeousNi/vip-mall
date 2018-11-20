package com.vip.constants;

/**
 * 短信常量类
 * @author GorgeousNi Created in 2018/11/18 4:04 PM
 * @Description:
 */
public class SmsConstant {

  /**
   * 发送频率限制（个人认证账号）
   * 对同一个手机号， 30秒 内发送短信条数不超过 1条
   * 对同一个手机号， 1小时 内发送短信条数不超过 5条
   * 对同一个手机号， 1个自然日 内发送短信条数不超过 10条
   */

  /**
   * 短信应用SDK AppID
   */
  public static final int appid = 1400162613;

  /**
   * 短信应用SDK AppKey
   */
  public static final String appkey = "9f65cd159cf5c6ad2d1248c70c40478e";

  /**
   * 短信模板ID，需要在短信应用中申请
   */
  int templateId = 7839; // NOTE: 这里的模板ID`7839`只是一个示例，真实的模板ID需要在短信控制台中申请
  /**
   * 签名
   */
  String smsSign = "唯品会"; // NOTE: 这里的签名"腾讯云"只是一个示例，真实的签名需要在短信控制台中申请，另外签名参数使用的是`签名内容`，而不是`签名ID`

}
