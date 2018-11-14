package com.vip.service.impl.user;

import com.vip.auth.JwtUtil;
import com.vip.base.Result;
import com.vip.common.UserCodeEnum;
import com.vip.common.UserConstants;
import com.vip.common.UserResult;
import com.vip.common.UserTokenParams;
import com.vip.dao.user.UBaseUserMapper;
import com.vip.model.user.UBaseUser;
import com.vip.request.user.UserLoginPasswdAccountReq;
import com.vip.request.user.UserRegisterPhoneReq;
import com.vip.request.user.base.BaseUserAccountReq;
import com.vip.response.user.UserLoginPasswdAccountRep;
import com.vip.service.user.BaseUserService;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 用户账号基础服务
 *
 * @author GorgeousNi Created in 2018/11/13 10:12 AM
 * @Description:
 */
@Service
public class BaseUserServiceImpl implements BaseUserService {

  @Autowired
  private UBaseUserMapper baseUserMapper;

  public Result loginPasswd(UserLoginPasswdAccountReq loginReq) {
    /**
     * 查询用户是否存在
     */
    UBaseUser baseUser = baseUserMapper.selectByAccountName(loginReq.getAccountName());
    if (baseUser == null) {
      return UserResult.failure(UserCodeEnum.ERROR_USER_NAME);
    }
    /**
     * 校验用户密码是否正确
     */
    if (!BCrypt.checkpw(loginReq.getLoginPasswd(), baseUser.getLoginPasswd())) {
      return UserResult.failure(UserCodeEnum.ERROR_USER_PASSWD);
    }
    /**
     * 返回用户token
     */
    UserTokenParams userTokenParams = new UserTokenParams();
    BeanUtils.copyProperties(baseUser,userTokenParams);
    UserLoginPasswdAccountRep rep = new UserLoginPasswdAccountRep();
    rep.setUtoken(JwtUtil.createJWT(UserConstants.USER_TOKEN,userTokenParams));
    return Result.success(rep);
  }

  public Result register(UserRegisterPhoneReq registerReq) {
    return null;
  }

  public Result checkUserExist(BaseUserAccountReq phoneReq) {
    return null;
  }
}
