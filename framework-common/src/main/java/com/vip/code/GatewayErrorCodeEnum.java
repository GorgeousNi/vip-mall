package com.vip.code;

/**
 * 签名异常类状态码
 *
 * @author GorgeousNi Created in 2018/7/11 下午3:25
 * @Title:
 * @Description:
 */
public enum GatewayErrorCodeEnum {

  REPEAT_REQUEST_ERROR("GATE101", "重复请求"),
  INPUT_MUST_NOT_NULL("GATE102", "参数不可为空"),
  REQUEST_VERIFY_FAIL("GATE103", "请求验签失败"),
  REQUEST_DECRYPT_FAIL("GATE104", "解密密文失败"),
  DATA_EXPIRED("GATE105", "更新数据已过期"),
  UN_KNOWN("GATE106", "未知错误"),
  MAXIMUM_LIMIT("GATE107", "超过最大查询记录限制"),
  ENUM_NOT_EXIST("GATE108", "无匹配的数据字典定义"),
  AUTH_ERROR("GATE109", "授权异常"),
  UNKNOW_METHOD_ERROR("GATE110", "该接口不存在"),
  UNKNOW_APPKEY_ERROR("GATE111", "非法的appkey"),
  SYSTEM_ERROR("GATE112", "系统异常"),
  ILLEGAL_IP("GATE113", "ip未加入白名单 "),
  OVERFLOW("GATE114", "访问超过限量 ");

  private String code;
  private String msg;

  public String getCode() {
    return this.code;
  }

  public String getMsg() {
    return this.msg;
  }

  public static GatewayErrorCodeEnum getFlag(String msg) {
    GatewayErrorCodeEnum[] var4;
    int var3 = (var4 = values()).length;

    for (int var2 = 0; var2 < var3; ++var2) {
      GatewayErrorCodeEnum an = var4[var2];
      if (msg != null && msg.equals(an.getCode())) {
        return an;
      }
    }

    return null;
  }

  private GatewayErrorCodeEnum(String code, String msg) {
    this.code = code;
    this.msg = msg;
  }

}
