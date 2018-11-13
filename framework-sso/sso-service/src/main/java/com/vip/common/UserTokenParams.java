package com.vip.common;

import com.vip.auth.TokenParams;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;

/**
 * 用户基础信息token
 *
 * @author GorgeousNi Created in 2018/11/13 4:40 PM
 * @Description:
 */
@Setter
@Getter
public class UserTokenParams extends TokenParams {

  private Long userId;

  private String userName;

  private String realName;

  private String loginPasswd;

  private String mobilePhone;

  private String email;

  private String userImgUrl;

  private String sex;

  private Date birthday;

  private String userStatus;

  private Date createTime;

  private Date updateTime;

}
