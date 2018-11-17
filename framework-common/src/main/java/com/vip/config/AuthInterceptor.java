package com.vip.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vip.auth.CheckResult;
import com.vip.auth.JwtUtil;
import com.vip.base.Result;
import com.vip.code.CodeEnum;
import com.vip.constants.ClaimsConstants;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * @author GorgeousNi on 2018/11/17 8:17 PM
 * @Description 用户token信息校验拦截器
 */
@Component
public class AuthInterceptor extends HandlerInterceptorAdapter {

  private Logger logger = LoggerFactory.getLogger(AuthInterceptor.class);

  @Value("${api.auth:false}")
  private String apiAuth = "false";

  @Override
  public boolean preHandle(HttpServletRequest request,
      HttpServletResponse response, Object handler) throws Exception {

    logger.info("Api Auth >>>>>" + apiAuth + "<<<< ");
    if ("true".equals(apiAuth)) {
      String authorization = request.getHeader(ClaimsConstants.AUTH_TOKEN_KEY);
      logger.info(" The AUTH_TOKEN_KEY is: {}", authorization);
      Result result = null;
      if (StringUtils.isBlank(authorization)) {
        result = Result.failure(CodeEnum.EMPTY_TOKEN);
      }
      CheckResult checkResult = JwtUtil.validateJWT(authorization);
      if (!checkResult.getIsSuccess()) {
        result = Result.failure(checkResult.getMsg(), checkResult.getCode());
      }
      if (!result.isSuccess()) {
        response.setHeader("Content-Type", ClaimsConstants.APPLICATION_JSON_UTF8);
        response.getWriter().write(new ObjectMapper().writeValueAsString(result));
        response.getWriter().flush();
        return false;
      }
    }
    return super.preHandle(request, response, handler);
  }

}
