package com.vip.request.user.base;

import com.vip.base.BaseParam;
import lombok.Getter;
import lombok.Setter;

/**
 * 用户token基础信息
 *
 * @author GorgeousNi Created in 2018/11/13 10:56 AM
 * @Description:
 */
@Setter
@Getter
public class BaseUserTokenReq extends BaseParam {

  /**
   * 用户token信息，包含用户基础信息
   */
  private String userToken;

}
