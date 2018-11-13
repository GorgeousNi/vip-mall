//package com.vip.advice;
//
//import com.alibaba.fastjson.JSON;
//import com.vip.utils.MD5;
//import com.vip.utils.PropertyReadUtils;
//import javax.annotation.PostConstruct;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.core.MethodParameter;
//import org.springframework.http.converter.HttpMessageConverter;
//import org.springframework.http.server.ServerHttpRequest;
//import org.springframework.http.server.ServerHttpResponse;
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;
//
///**
// * 对于@ResponseBody的返回结果加密，同理可以写解密方法拦截 TODO 该类测试中，加密方法待更换
// *
// * @author GorgeousNi Created in 2018/7/10 下午3:41
// * @Title:
// * @Description:
// */
//@ControllerAdvice
//public class MyResponseBodyAdvice implements ResponseBodyAdvice<ResponseResult> {
//
//  private Logger logger = LoggerFactory.getLogger(MyResponseBodyAdvice.class);
//
//  /**
//   * 加密串一
//   */
//  private static String md5_keyone;
//  /**
//   * 加密串二
//   */
//  private static String md5_keytwo;
//
//  @PostConstruct
//  public void init() throws Exception {
//    md5_keyone = PropertyReadUtils.getValue("config/sign.properties", "md5_keyone");
//    md5_keytwo = PropertyReadUtils.getValue("config/sign.properties", "md5_keytwo");
//  }
//
//  /**
//   * 判断支持的类型 是否拦截
//   *
//   * @author GorgeousNi on 2018/7/10 下午5:08
//   */
//  public boolean supports(MethodParameter returnType,
//      Class<? extends HttpMessageConverter<?>> converterType) {
//    return returnType.getMethod().getReturnType().isAssignableFrom(ResponseResult.class);
//  }
//
//
//  /**
//   * 对于结果进行加密,加密方法待完善
//   *
//   * @author GorgeousNi on 2018/7/10 下午5:09
//   */
//  public ResponseResult beforeBodyWrite(ResponseResult body, MethodParameter returnType,
//      org.springframework.http.MediaType selectedContentType,
//      Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request,
//      ServerHttpResponse response) {
//
//    String jsonString = JSON.toJSONString(body.getEncryptJson());
//    logger.info("<<<< 加密前字符串 " + jsonString + " >>>>");
//    // 第一次加密
//    String data_encode_one = MD5.encryptPassword(jsonString, md5_keyone);
//    // 第二次加密
//    String data_encode_two = MD5.encryptPassword(data_encode_one, md5_keytwo);
//    body.setEncryptJson(data_encode_two);
//    return body;
//  }
//
//}