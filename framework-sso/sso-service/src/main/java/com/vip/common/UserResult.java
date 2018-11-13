package com.vip.common;


import com.vip.base.Result;

/**
 * @author GorgeousNi Created in 2018/11/13 3:54 PM
 * @Description:
 */
public class UserResult extends Result {

  /**
   * @Description 签名异常返回结果集
   * @author GorgeousNi on 2018/7/11 下午3:47
   */
  public static UserResult failure(UserCodeEnum codeEnum) {
    UserResult result = new UserResult();
    result.setMsg(codeEnum.getMsg());
    result.setCode(codeEnum.getCode()) ;
    result.setSuccess(false);
    return result;
  }

}
