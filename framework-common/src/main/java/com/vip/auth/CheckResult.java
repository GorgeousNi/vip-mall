package com.vip.auth;

import io.jsonwebtoken.Claims;

/**
 * jwt 校验结果
 *
 * @Title:
 * @Description:
 * @Author GorgeousNi Created in 2018/5/23 下午6:03
 */
public class CheckResult {

  private Boolean success;

  private String msg;

  private String code;

  private Claims claims;

  public Boolean getSuccess() {
    return success;
  }

  public void setSuccess(Boolean success) {
    this.success = success;
  }

  public String getMsg() {
    return msg;
  }

  public void setMsg(String msg) {
    this.msg = msg;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public Claims getClaims() {
    return claims;
  }

  public void setClaims(Claims claims) {
    this.claims = claims;
  }

  @Override
  public String toString() {
    final StringBuffer sb = new StringBuffer("CheckResult{");
    sb.append("success=").append(success);
    sb.append(", msg='").append(msg).append('\'');
    sb.append(", code='").append(code).append('\'');
    sb.append(", claims=").append(claims);
    sb.append('}');
    return sb.toString();
  }
}
