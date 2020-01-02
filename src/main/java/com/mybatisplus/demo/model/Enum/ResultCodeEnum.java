package com.mybatisplus.demo.model.Enum;

import java.text.MessageFormat;

/** 通用错误码 */
public enum ResultCodeEnum {
  OK(1, ""),
  FAIL(-1, "系统异常，请联系管理员！"),
  SAVE(5, "保存成功"),
  SAVE_FAIL(-5, "保存失败"),
  CREATE(5, "创建成功"),
  CREATE_FAIL(-5, "创建失败"),
  UPDATE(6, "更新成功"),
  UPDATE_FAIL(-6, "更新失败"),
  DELETE(7, "删除成功"),
  DELETE_FAIL(-7, "删除失败"),
  RPC_ERROR(-2, "远程调度失败"),
  // FEIGNCLIENT_ERROR(-3, "微服务故障, 请稍后再试。"),
  FEIGNCLIENT_EXCEPTION(-3, "远程服务调度失败:[{0}]的[{1}]接口暂时不可用。"),
  USER_NOLOGED(-4, "未登录或登录已超时"),
  EROR_DATA(-100, ""),

  DATAPERMISSION_DATATYPE_MAP_ERROR(-101, "数据权限接口参数必须为Map类型"),
  DATAPERMISSION_ILLEGALACCESSEXCEPTION_ERROR(-103, "数据权限接口参数存在错误:实体类操作权限出现问题"),
  DATAPERMISSION_PERMISSION_ERROR(-104, "数据权限接口参数存在错误:数据权限不正确"),
  USER_NOT_FOUND(-1000, "登录失败：用户不存在"),
  USER_PASSWORD_ERROR(-1001, "登录失败：密码错误"),
  USER_NAMEORPASSWORD_ISBLANK(-1002, "登录失败：用户、密码不能为空"),
  GET_TOKEN_FAIL(-1002, "获取token失败"),
  TOKEN_IS_NOT_MATCH_USER(-1003, "请使用自己的token进行接口请求"),
  USER_STATUS_DELETE(-1010, "登录失败： 帐号已删除，请联系管理员"),
  USER_STATUS_STOP(-1011, "登录失败：帐号已停用，请联系管理员"),
  USER_STATUS_FREEZE(-1012, "登录失败：帐号已冻结，请联系管理员"),
  USER_STATUS_TO_ENABLE(-1013, "登录失败：帐号待启用，请联系管理员"),
  USER_STATUS_OTHER(-1019, "登录失败：帐号状态不正确，请联系管理员"),
  USER_LOGON_ERROR(-1020, "登录失败：系统异常"),
  HTTP_ERROR_401(-401, "请求失败：请求未通过认证"),
  HTTP_ERROR_403(-403, "请求失败：访问被服务器拒绝"),
  HTTP_ERROR_404(-404, "请求失败：服务器上没有找到请求的资源"),
  HTTP_ERROR_500(-500, "请求失败：服务器发生错误"),
  HTTP_ERROR_OTHER(-600, "请求失败：服务器发生错误");

  private int code;
  private String msg;

  ResultCodeEnum(int code, String msg) {
    this.code = code;
    this.msg = msg;
  }

  public int getCode() {
    return code;
  }

  public String getMsg() {
    return msg;
  }

  public String getMsg(String... strs) {
    return MessageFormat.format(msg, strs);
  }

  public static ResultCodeEnum codeOf(int code) {
    for (ResultCodeEnum errorCode : values()) {
      if (errorCode.getCode() == code) {
        return errorCode;
      }
    }
    return null;
  }
}
