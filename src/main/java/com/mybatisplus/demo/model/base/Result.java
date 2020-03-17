package com.mybatisplus.demo.model.base;

import com.mybatisplus.demo.model.Enum.ResultCodeEnum;
import com.mybatisplus.demo.model.constant.CommonConstant;
import lombok.Data;

@Data
public class Result<T> {

  public Result() {
    this.code = ResultCodeEnum.OK.getCode();
  }

  public Result(ResultCodeEnum code) {
    setAndReturn(code);
  }

  private int code;
  private String msg;
  private String ExceptionInfo;
  private T data;

  /**
   * 设置返回代码和提示信息并返回对象。
   *
   * @param code
   * @return
   */
  public Result<T> setAndReturn(ResultCodeEnum code) {
    this.code = code.getCode();
    this.setMsg(code.getMsg());
    return this;
  }

  public Result(int code, String msg) {
    this.code = code;
    this.setMsg(msg);
  }

  public Result<T> Result(int code, String msg) {
    this.code = code;
    this.setMsg(msg);
    return this;
  }

  public Result<T> setCode(ResultCodeEnum code) {
    this.code = code.getCode();
    this.msg = code.getMsg();
    return this;
  }

  public Result<T> setData(T _data) {
    this.data = _data;
    return this;
  }

  public Result(T _data) {
    this.code = ResultCodeEnum.OK.getCode();
    this.data = _data;
  }

  public static Result<Object> error(int code, String msg) {
    Result<Object> r = new Result<>();
    r.setCode(code);
    r.setMsg(msg);
    return r;
  }

  public static Result<Object> error(String msg) {
    return error(CommonConstant.SC_INTERNAL_SERVER_ERROR_500, msg);
  }

  public void setCode(int code) {
    this.code = code;
  }
}
