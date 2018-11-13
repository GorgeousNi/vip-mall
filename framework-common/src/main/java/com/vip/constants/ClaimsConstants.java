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
   * iss(签发者),exp(过期时间),sub(面向的用户),aud(接收方)，iat(签发时间)
   */
  public static final String ISSUER = "KXB";
  public static final String SUBJECT = "";
  public static final String AUDIENCE = "098f6bcd4621d373cade4e8we2we232627b4f6";
  public static final Long EXPIRATION = 300000L; //jwt过期时间：1s
  public static final String NOT_BEFORE = "";
  public static final String ID = "";


  /**
   * jwt过期时间：60*5*1000*1 毫秒 = 5分钟
   */
  Long JWT_EXPIRE_5_MIN = 300000L;

  /**
   * jwt过期时间：30L * 24L * 60*60 * 1000L  = 30天
   */
  Long JWT_EXPIRE_30_DATE = 2592000000L;
}
