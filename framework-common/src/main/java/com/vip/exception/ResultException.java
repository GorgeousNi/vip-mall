package com.vip.exception;


import com.vip.code.CodeEnum;

/**
 * 自定义结果异常，会被 ExceptionHandler 捕捉并返回给前端
 *
 * @author GorgeousNi Created in 2018/7/9 下午2:40
 * @Title:
 * @Description:
 */
public class ResultException extends RuntimeException {

  private static final long serialVersionUID = 4110729868140341181L;
  private CodeEnum codeEnum;


  public ResultException(CodeEnum codeEnum) {
    super(codeEnum.getMsg());
    this.codeEnum = codeEnum;
  }

  public ResultException(CodeEnum codeEnum, String msg) {
    super(msg);
    this.codeEnum = codeEnum;
  }

  public ResultException(CodeEnum codeEnum, Throwable cause) {
    super(cause);
    this.codeEnum = codeEnum;
  }

  public ResultException(CodeEnum codeEnum, String msg, Throwable cause) {
    super(msg, cause);
    this.codeEnum = codeEnum;
  }

  public CodeEnum getResultCode() {
    return codeEnum;
  }

}
