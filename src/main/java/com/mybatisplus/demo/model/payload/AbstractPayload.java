package com.mybatisplus.demo.model.payload;

public abstract class AbstractPayload {

  protected static final int CODE_OK = 0;
  protected static final String MESSAGE_OK = "OK";

  private Integer code = CODE_OK;
  private String message = MESSAGE_OK;

  public AbstractPayload(Integer code, String message) {
    if (code != null) {
      this.code = code;
    }

    if (message != null) {
      this.message = message;
    }
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public Integer getCode() {
    return code;
  }

  public void setCode(Integer code) {
    this.code = code;
  }
}
