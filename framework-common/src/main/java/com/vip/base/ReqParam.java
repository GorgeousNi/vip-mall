package com.vip.base;


import java.io.Serializable;

/**
 * 请求参数封装，便于后期增加sign、token验证
 *
 * @Title:
 * @Description:
 * @Author GorgeousNi Created in 2018/4/30 下午6:17
 */
public class ReqParam<T extends BaseParam> implements Serializable {

  private String sign;
  private String sysCode;
  private String token;
  private String timestamp;
  private String callback;
  private T sendData;

  public String getSign() {
    return sign;
  }

  public void setSign(String sign) {
    this.sign = sign;
  }

  public T getSendData() {
    return sendData;
  }

  public void setSendData(T sendData) {
    this.sendData = sendData;
  }

  public String getSysCode() {
    return sysCode;
  }

  public void setSysCode(String sysCode) {
    this.sysCode = sysCode;
  }

  public String getToken() {
    return token;
  }

  public void setToken(String token) {
    this.token = token;
  }

  public String getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(String timestamp) {
    this.timestamp = timestamp;
  }

  public String getCallback() {
    return callback;
  }

  public void setCallback(String callback) {
    this.callback = callback;
  }

}
