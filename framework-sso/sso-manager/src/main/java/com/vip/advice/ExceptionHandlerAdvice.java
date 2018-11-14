package com.vip.advice;

import com.alibaba.fastjson.JSON;
import com.vip.base.Result;
import com.vip.code.CodeEnum;
import com.vip.exception.GatewayException;
import com.vip.exception.ResultException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;


/**
 * 统一自定义异常处理，避免使用父级 Controller 完成异常处理，代码耦合严重
 *
 * @author GorgeousNi Created in 2018/7/9 下午2:44
 * @Title:
 * @Description:
 */
@ControllerAdvice
@ResponseBody
public class ExceptionHandlerAdvice implements ResponseBodyAdvice {

  private ThreadLocal<Object> modelHolder = new ThreadLocal<Object>();
  private Logger logger = LoggerFactory.getLogger(ExceptionHandlerAdvice.class);

  @ExceptionHandler(MethodArgumentNotValidException.class)
  public Result handleIllegalParamException(MethodArgumentNotValidException e) {
    List<ObjectError> errors = e.getBindingResult().getAllErrors();
    String tips = "参数不合法";
    if (errors.size() > 0) {
      tips = errors.get(0).getDefaultMessage();
    }
    Result result = Result.failure(CodeEnum.PARAMETER_ERROR);
    result.setMsg(tips);
    return result;
  }

  /**
   * @param e 自定义异常捕捉
   * @return com.vip.base.Result
   * @Description
   * @author GorgeousNi on 2018/7/11 下午3:11
   */
  @ExceptionHandler(ResultException.class)
  public Result handleResultException(ResultException e, HttpServletRequest request) {
    if (modelHolder.get() == null) {
      return Result.failure(CodeEnum.ERROR_HTTP);
    }
    logger.debug("uri={} | requestBody={}", request.getRequestURI(),JSON.toJSONString(modelHolder.get()));
    return Result.failure(e.getResultCode());
  }


  /**
   * @param e 自定义异常捕捉
   * @return com.vip2.base.Result
   * @Description
   * @author GorgeousNi on 2018/7/11 下午3:20
   */
  @ExceptionHandler(GatewayException.class)
  public Result handleGatewayException(GatewayException e, HttpServletRequest request) {
    if (modelHolder.get() == null) {
      return Result.failure(CodeEnum.ERROR_HTTP);
    }
    logger.debug("uri={} | requestBody={}", request.getRequestURI(),
        JSON.toJSONString(modelHolder.get()));
    return Result.failure(e.getResultCode());
  }

  @ExceptionHandler(Exception.class)
  public Result handleException(Exception e, HttpServletRequest request) {
    if (modelHolder.get() == null) {
      return Result.failure(CodeEnum.ERROR_HTTP);
    }
    logger.error("uri={} | requestBody={}", request.getRequestURI(),
        JSON.toJSONString(modelHolder.get()), e);
    return Result.failure(CodeEnum.ERROR);
  }

  @InitBinder
  public void initBinder(WebDataBinder webDataBinder) {
    // ModelHolder 初始化
    modelHolder.set(webDataBinder.getTarget());
  }


  public boolean supports(MethodParameter returnType, Class converterType) {
    return true;
  }


  public Object beforeBodyWrite(Object body, MethodParameter returnType,
      MediaType selectedContentType,
      Class selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
    // ModelHolder 清理
    modelHolder.remove();
    return body;
  }

}
