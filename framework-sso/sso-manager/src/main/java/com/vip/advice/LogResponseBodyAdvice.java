package com.vip.advice;

import com.vip.utils.JsonDesUtils;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * 返回体日志统一处理
 *
 * @author GorgeousNi Created in 2018/7/9 下午3:02
 * @Title:
 * @Description:
 */
@ControllerAdvice
public class LogResponseBodyAdvice implements ResponseBodyAdvice {

  private Logger logger = LoggerFactory.getLogger(LogResponseBodyAdvice.class);

  public boolean supports(MethodParameter returnType, Class converterType) {
    return true;
  }

  public Object beforeBodyWrite(Object body, MethodParameter returnType,
      MediaType selectedContentType,
      Class selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {

//    logger.info(" <<<<< 接口请求结果 " + JSONObject.toJSON(body) + " >>>>>");

    if (logger.isDebugEnabled()) {
      HttpServletRequest servletRequest = ((ServletServerHttpRequest) request).getServletRequest();
      String requestUriWithoutContextPath = servletRequest.getRequestURI()
          .substring(servletRequest.getContextPath().length());
      logger.debug("uri={} | responseBody={}", requestUriWithoutContextPath,
          JsonDesUtils.toLogString(body));
    }
    return body;
  }

}
