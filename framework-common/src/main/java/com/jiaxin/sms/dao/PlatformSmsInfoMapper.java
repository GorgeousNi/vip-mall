package com.jiaxin.sms.dao;

import com.jiaxin.sms.model.PlatformSmsInfo;

public interface PlatformSmsInfoMapper {
    int deleteByPrimaryKey(Long smsInfoId);

    int insert(PlatformSmsInfo record);

    int insertSelective(PlatformSmsInfo record);

    PlatformSmsInfo selectByPrimaryKey(Long smsInfoId);

    int updateByPrimaryKeySelective(PlatformSmsInfo record);

    int updateByPrimaryKey(PlatformSmsInfo record);
}