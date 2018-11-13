package com.vip.utils;

import java.io.IOException;
import java.io.Serializable;
import java.util.Properties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 读取properties文件的工具类
 *
 * @author GorgeousNi Created in 2018/7/10 下午5:12
 * @Title:
 * @Description:
 */
public class PropertyReadUtils implements Serializable {

  private static Properties p = null;
  private static Logger logger = LoggerFactory.getLogger(PropertyReadUtils.class);

  /**
   * @Description 根据key得到value的值 configFilePath 文件名 , key 获取的键
   * @author GorgeousNi on 2018/7/10 下午5:17
   */
  public static String getValue(String configFilePath, String key) {
    if (p == null) {
      p = new Properties();
    }
    try {
      //读取properties配置文件信息
      p.load(PropertyReadUtils.class.getClassLoader().getResourceAsStream(configFilePath));
      return p.getProperty(key).trim();
    } catch (IOException e) {
      logger.error("<<<< 读取配置文件" + configFilePath + "出错," + e.getMessage() + ">>>>");
    }
    return null;
  }

//  public static void main(String[] args) {
//    //测试
//
//    PropertyReadUtils utils = new PropertyReadUtils();
//    String value = utils.getValue("config/sign.properties","server.ssl.keyAlias1");
//    System.out.println(value);
//  }

}


