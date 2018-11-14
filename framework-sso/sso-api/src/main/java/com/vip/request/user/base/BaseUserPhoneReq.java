package com.vip.request.user.base;

import com.vip.base.BaseParam;
import lombok.Getter;
import lombok.Setter;

/**
 * 用户基础信息 手机号
 *
 * @author GorgeousNi Created in 2018/11/14 9:31 PM
 * @Description:
 */
@Setter
@Getter
public class BaseUserPhoneReq extends BaseParam {

  /**
   * 手机号
   */
  private String mobilePhone;

}
