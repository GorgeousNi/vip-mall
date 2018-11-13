package com.vip.advice;

import java.io.Serializable;

/**
 * 返回加密的json字符串的结果集
 *
 * @author GorgeousNi Created in 2018/7/10 下午5:01
 * @Title:
 * @Description:
 */
public class ResponseResult implements Serializable {

  String encryptJson;//加密后的值


  public String getEncryptJson() {
    return encryptJson;
  }

  public void setEncryptJson(String encryptJson) {
    this.encryptJson = encryptJson;
  }
}
