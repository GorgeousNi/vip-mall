package com.vip.base;


import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

/**
 * @author GorgeousNi on 2018/11/12 11:46 AM
 * @Description 请求参数封装
 */
@Setter
@Getter
public class ReqParam<T extends BaseParam> implements Serializable {

  /**
   * 签名
   */
  private String sign;
  /**
   * 系统接口请求来源
   */
  private String sysCode;
  /**
   * 用户token
   */
  private String token;
  /**
   * 时间戳
   */
  private String timestamp;
  /**
   * 请求来源 www、app
   */
  private String whereFrom;
  /**
   * 请求参数 主体
   */
  private T sendData;

}
