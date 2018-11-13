package com.vip.exception;


import com.vip.code.GatewayErrorCodeEnum;

/**
 * 自定义异常-签名异常类
 *
 * @author GorgeousNi Created in 2018/7/10 下午8:39
 * @Title:
 * @Description:
 */
public class GatewayException extends Exception {

  private static final long serialVersionUID = 3602326863773175961L;
  private GatewayErrorCodeEnum codeEnum;


  public GatewayException(GatewayErrorCodeEnum codeEnum) {
    super(codeEnum.getMsg());
    this.codeEnum = codeEnum;
  }

  public GatewayException(GatewayErrorCodeEnum codeEnum, String msg) {
    super(msg);
    this.codeEnum = codeEnum;
  }

  public GatewayException(GatewayErrorCodeEnum codeEnum, Throwable cause) {
    super(cause);
    this.codeEnum = codeEnum;
  }

  public GatewayException(GatewayErrorCodeEnum codeEnum, String msg, Throwable cause) {
    super(msg, cause);
    this.codeEnum = codeEnum;
  }

  public GatewayErrorCodeEnum getResultCode() {
    return codeEnum;
  }


}
