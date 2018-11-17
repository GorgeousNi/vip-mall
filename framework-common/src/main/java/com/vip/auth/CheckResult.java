package com.vip.auth;

import io.jsonwebtoken.Claims;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

/**
 * @author GorgeousNi on 2018/11/17 8:07 PM
 * @Description jwt 校验结果
 */
@Setter
@Getter
public class CheckResult implements Serializable {

  private Boolean isSuccess;

  private String msg;

  private String code;

  private Claims claims;

  @Override
  public String toString() {
    final StringBuffer sb = new StringBuffer("CheckResult{");
    sb.append("success=").append(isSuccess);
    sb.append(", msg='").append(msg).append('\'');
    sb.append(", code='").append(code).append('\'');
    sb.append(", claims=").append(claims);
    sb.append('}');
    return sb.toString();
  }
}
