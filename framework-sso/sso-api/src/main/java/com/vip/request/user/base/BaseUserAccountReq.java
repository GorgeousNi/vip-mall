package com.vip.request.user.base;

import com.vip.base.BaseParam;
import lombok.Getter;
import lombok.Setter;

/**
 * 用户基础信息 用户名
 *
 * @author GorgeousNi Created in 2018/11/13 2:21 PM
 * @Description:
 */
@Setter
@Getter
public class BaseUserAccountReq extends BaseParam{

  /**
   * 账号名（用户名/绑定手机号/绑定邮箱名）
   */
  private String accountName;

}
