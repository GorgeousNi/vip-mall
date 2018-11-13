///**
// * 文 件 名:  AcctLimitConfig
// * 版    权:  Quanten Teams. Copyright YYYY-YYYY,  All rights reserved
// * 描    述:  <描述>
// * 修 改 人:  zhouhaofeng
// * 修改时间:  2018/1/30
// * 跟踪单号:  <跟踪单号>
// * 修改单号:  <修改单号>
// * 修改内容:  <修改内容>
// */
//package com.vip.config;
//
//import com.huawei.album.wechat.common.config.AcctLimitationConfig;
//import com.huawei.album.wechat.dao.entity.AccountDO;
//import com.huawei.album.wechat.dao.mapper.AccountMapper;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.ApplicationArguments;
//import org.springframework.boot.ApplicationRunner;
//import org.springframework.stereotype.Component;
//
//import java.util.List;
//
///**
// * 读取允许登录账号列表
// *
// * @author zhouhaofeng
// * @version 2018/1/30
// * @see [相关类/方法]
// * @since [产品/模块版本]
// */
//@Component
//public class AllowLoginAcctConfig implements ApplicationRunner
//{
//	private static final Logger logger = LoggerFactory.getLogger (AllowLoginAcctConfig.class);
//
//	@Autowired
//	private AccountMapper accountMapper;
//
//	@Override
//	public void run (ApplicationArguments applicationArguments) throws Exception
//	{
//		logger.debug (">>>>>>>>>>>>>>>>>>>>[startup]load account data from the database begin......");
//		//调用数据库查询平台有效账号列表并保存在内存中
//		List<AccountDO> accountDOList = accountMapper.listEffectiveAcct ();
//		accountDOList.forEach (accountDO -> AcctLimitationConfig.ALLOW_LOGIN_ACCT_MAP
//				.put (accountDO.getAccount (), accountDO.getRoleId ()));
//		logger.debug (">>>>>>>>>>>>>>>>>>>>[startup]load account data from the database end......");
//	}
//}
