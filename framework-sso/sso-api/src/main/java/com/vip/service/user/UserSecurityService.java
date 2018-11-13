package com.vip.service.user;

import com.vip.base.Result;
import com.vip.request.user.ModifyPhoneByBankCardReq;
import com.vip.request.user.UserBindEmailReq;
import com.vip.request.user.UserBindPasswdReq;
import com.vip.request.user.ModifyPhoneByVerifyCodeReq;

/**
 * 账号安全性服务
 *
 * @author GorgeousNi Created in 2018/11/13 11:33 AM
 * @Description:
 */
public interface UserSecurityService {

  /**
   * 手机号验证码身份校验
   */

  /**
   * @Description 重置密码 1、手机号验证码身份验证 2、旧密码校验 3、重置
   * @author GorgeousNi on 2018/11/13 2:17 PM
   */
  Result toResetPasswd(UserBindPasswdReq passwdReq);

  /**
   * @Description 邮箱绑定 1、手机号验证码身份校验 2、发送邮箱 3、校验邮箱
   * @author GorgeousNi on 2018/11/13 11:49 AM
   */
  Result toBindEmail(UserBindEmailReq emailReq);

  /**
   * @Description 根据手机号验证码校验 修改绑定手机号
   * @author GorgeousNi on 2018/11/13 11:50 AM
   */
  Result modifyPhoneByVerifycode(ModifyPhoneByVerifyCodeReq verifyCodeReq);

  /**
   * @Description 根据银行卡+身份证+银行预留手机号验证码校验 修改绑定手机号
   * @author GorgeousNi on 2018/11/13 11:50 AM
   */
  Result modifyPhoneByBankcard(ModifyPhoneByBankCardReq bankCardReq);


}
