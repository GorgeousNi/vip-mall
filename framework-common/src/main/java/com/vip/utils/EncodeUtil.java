package com.vip.utils;


import java.util.Base64;
import java.util.Date;

/**
 * base64编码解码工具类
 *
 * @Title:
 * @Description:
 * @Author GorgeousNi Created in 2018/5/23 下午5:39
 */
public class EncodeUtil {

  /**
   * base64编码
   *
   * @param str base64编码前的字符串
   * @return base64编码后的字符串
   */
  public static String base64Encode(String str) {
    return Base64.getEncoder().encodeToString(str.getBytes());
  }

  /**
   * base64编码
   *
   * @param bytes base64编码前byte
   * @return base64编码后的字符串
   */
  public static String base64Encode(byte[] bytes) {
    return Base64.getEncoder().encodeToString(bytes);
  }

  /**
   * base64解码
   *
   * @param base64Str base64解码前的字符串
   * @return base64解码后的字符串
   */
  public static String base64Decode(String base64Str) {
    byte[] strByte = Base64.getDecoder().decode(base64Str);
    return new String(strByte);
  }

  /**
   * base64解码
   *
   * @param base64Str base64解码前的字符串
   * @return base64解码后的byte数组
   */
  public static byte[] base64DecodeToByte(String base64Str) {
    return Base64.getDecoder().decode(base64Str);
  }

  //public static void main(String[] args) {
  //  System.out.println(base64Encode("123456" + new Date().getTime()));
  //}
}
