package com.mybatisplus.demo.model.payload;

public class ErrorPayload extends AbstractPayload {

  private String error;

  public ErrorPayload(Integer code, String message) {
    this(code, message, null);
  }

  public ErrorPayload(Integer code, String message, String error) {
    super(code, message);
    this.error = error;
  }

  public String getError() {
    return error;
  }

  public void setError(String error) {
    this.error = error;
  }
}
