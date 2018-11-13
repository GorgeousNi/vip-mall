package com.vip.base;

import com.vip.code.CodeEnum;
import com.vip.code.GatewayErrorCodeEnum;
import com.vip.code.SmsErrorCodeEnum;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author GorgeousNi on 2018/11/13 10:25 AM
 * @Description 返回结果集类
 */
@SuppressWarnings("serial")
public class Result implements Serializable {

  private Object data;//返回对象
  private boolean isSuccess;//是否操作成功
  private String msg;//操作结果信息
  private String code;//操作结果编码
  private static final String SUCCESSCODE = "200";
  private static final String ERRORCODE = "500";

  /**
   * 操作成功
   */
  public static Result success() {
    Result rs = success(SUCCESSCODE);
    rs.msg = "操作成功";
    return rs;
  }

  /**
   * 操作成功
   */
  public static Result success(String code) {
    Result result = new Result();
    result.isSuccess = true;
    result.code = code;
    result.msg = "操作成功";
    return result;
  }

  /**
   * 操作成功
   */
  public static Result success(Object data) {
    return success(data, "200");
  }

  /**
   * 操作成功
   */
  public static Result success(Object data, String code) {
    Result result = success();
    result.data = data;
    result.code = code;
    result.msg = "操作成功";
    return result;
  }

  /**
   * 操作失败
   */
  public static Result failure() {
    return failure("操作失败", "-1");
  }

  /**
   * 操作失败
   */
  public static Result failure(String msg) {
    return failure(msg, "-1");
  }

  /**
   * 操作失败
   */
  public static Result failure(String msg, String code) {
    Result result = new Result();
    result.msg = msg;
    result.code = code;
    result.isSuccess = false;
    return result;
  }


  /**
   * 操作失败
   */
  public static Result failure(CodeEnum codeEnum) {
    Result result = new Result();
    result.msg = codeEnum.getMsg();
    result.code = codeEnum.getCode() + "";
    result.isSuccess = false;
    return result;
  }

  /**
   * 操作成功
   */
  public static Result success(CodeEnum codeEnum) {
    Result result = new Result();
    result.msg = codeEnum.getMsg();
    result.code = codeEnum.getCode() + "";
    result.isSuccess = true;
    return result;
  }

  /**
   * @Description 签名异常返回结果集
   * @author GorgeousNi on 2018/7/11 下午3:47
   */
  public static Result failure(GatewayErrorCodeEnum codeEnum) {
    Result result = new Result();
    result.msg = codeEnum.getMsg();
    result.code = codeEnum.getCode() + "";
    result.isSuccess = false;
    return result;
  }


  /**
   * 短信发送异常返回结果集
   */
  public static Result failure(SmsErrorCodeEnum smsErrorCodeEnum) {
    Result result = new Result();
    result.msg = smsErrorCodeEnum.getMsg();
    result.code = smsErrorCodeEnum.getCode() + "";
    result.isSuccess = false;
    return result;
  }

  ///**
  // * 操作成功
  // */
  //public static <T> Result successByPage(Page<T> page, String listName, String code) {
  //  Map<String, Object> data = new HashMap<String, Object>();
  //  Map<String, Object> pageItem = new HashMap<String, Object>();
  //  pageItem.put("pageNo", page.getPageNum());
  //  pageItem.put("pageSize", page.getPageSize());
  //  pageItem.put("totalNo", page.getTotal());
  //  data.put("page", pageItem);
  //  data.put(listName, page.getList());
  //  return Result.success(data, code);
  //}

  /**
   * 操作成功
   */
  public static <T> Result successByList(List<T> list, String listName, String code) {
    Map<String, List<T>> map = new HashMap<String, List<T>>();
    map.put(listName, list);
    return Result.success(map, code);
  }

  /**
   * 操作失败
   */
  public static Result failure(String msg, Exception exception) {
    Result result = failure(msg);
    result.data = exception;
    result.code = ERRORCODE;
    result.isSuccess = false;
    result.msg = "操作失败";
    return result;
  }


  public Object getData() {
    return data;
  }

  public void setData(Object data) {
    this.data = data;
  }

  public boolean isSuccess() {
    return isSuccess;
  }

  public void setSuccess(boolean success) {
    isSuccess = success;
  }

  public String getMsg() {
    return msg;
  }

  public void setMsg(String msg) {
    this.msg = msg;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

}