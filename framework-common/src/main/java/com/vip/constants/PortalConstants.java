package com.vip.constants;

/**
 * 授权常量类
 *
 * @Title:
 * @Description:
 * @Author GorgeousNi Created in 2018/5/23 下午5:50
 */
public interface PortalConstants {


  interface Auth {


    /**
     * base64 加密密钥
     */
    String SECURITY = "MDk4ZjZiY2Q0NjIxZDM3M2NhZGU0ZTMjYyNAYMSHS2I0ZjY=";

    /**
     * cookies名称
     */
    String AUTH_KEY = "authorization";
    /**
     * 加密密钥
     */
    String AUTH_SECRET_KEY = "wechatsecret";
    /**
     * jwt过期错误码
     */
    String JWT_ERROR_EXPIRE_CODE = "27000000";
    /**
     * jwt过期错误描述
     */
    String JWT_ERROR_EXPIRE_DESC = "token has expired!";
    /**
     * jwt解析错误码
     */
    String JWT_ERROR_FAIL_CODE = "27000001";
    /**
     * jwt过期错误描述
     */
    String JWT_ERROR_FAIL_DESC = "token signature error!";
    /**
     * jwt校验通过提示码
     */
    String JWT_SUCCESS_CODE = "0";

    /**
     * jwt校验通过提示语
     */
    String JWT_SUCCESS_DESC = "success";


    /**
     * jwt过期时间：60*60*1000*1 毫秒 = 1小时
     */
    Long JWT_EXPIRE_1_TIME = 3600000L;

    /**
     * jwt过期时间：60*5*1000*1 毫秒 = 5分钟
     */
    Long JWT_EXPIRE_5_MIN = 300000L;

    /**
     * jwt过期时间：60*60*1000*24 毫秒 = 24小时
     */
    Long JWT_EXPIRE_1_DATE = 86400000L;
    /**
     * jwt过期时间：15L * 24L * 60*60 * 1000L  = 15天
     */
    Long JWT_EXPIRE_15_DATE = 1296000000L;
    /**
     * jwt过期时间：30L * 24L * 60*60 * 1000L  = 30天
     */
    Long JWT_EXPIRE_30_DATE = 2592000000L;


    /**
     * cookies过期时间：60*60*8=28800秒 = 8个小时
     */
    Integer COOKIES_EXPIRE_TIME = 28800;
  }

  interface MediaType {

    String ENCODE_UTF8 = "UTF-8";
    String APPLICATION_JSON_UTF8 = "application/json;charset=utf-8";
  }

}
