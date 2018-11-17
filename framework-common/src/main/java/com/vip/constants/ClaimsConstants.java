package com.vip.constants;

import com.vip.base.BaseModel;

/**
 * token签发常量
 *
 * @author GorgeousNi Created in 2018/11/13 5:00 PM
 * @Description:
 */
public class ClaimsConstants implements BaseModel {

  /**
   * 用户token信息名称
   */
  public static final String AUTH_TOKEN_KEY = "authorization";
  /**
   * base64 加密密钥
   */
  public static final String AUTH_SECURITY = "MDk4ZjZiY2Q0NjIxZDM3M2NhZAUTHGU0ZTMjYyNAYMSHS2I0ZjY=";

  /**
   * header类型
   */
  public static final String APPLICATION_JSON_UTF8 = "application/json;charset=utf-8";

  /**
   * iss(签发者),exp(过期时间),sub(面向的用户),aud(接收方)，iat(签发时间)
   */
  public static final String ISSUER = "KXB";
  public static final String SUBJECT = "";
  public static final String AUDIENCE = "098f6bcd4621d373cade4e8we2we232627b4f6";
  /**
   * jwt过期时间：60*15*1000*1 毫秒 = 15分钟
   */
  public static final Long EXPIRATION = 900000L;
  public static final String NOT_BEFORE = "";
  public static final String ID = "";



}
