package com.vip.dao.user;


import com.vip.model.user.UBaseUser;

public interface UBaseUserMapper {
    int deleteByPrimaryKey(Long userId);

    int insert(UBaseUser record);

    int insertSelective(UBaseUser record);

    UBaseUser selectByPrimaryKey(Long userId);

    int updateByPrimaryKeySelective(UBaseUser record);

    int updateByPrimaryKey(UBaseUser record);

    /**
     * 根据用户名查询用户信息(accountName = mobilePhone or email or userName）
     */
    UBaseUser selectByAccountName(String accountName);


}