package com.mybatisplus.demo.model.payload;

public class EntityPayload<T> extends AbstractPayload {

  private T data;

  public EntityPayload(T data) {
    this(null, null, data);
  }

  public EntityPayload(Integer code, String message, T data) {
    super(code, message);
    this.setData(data);
  }

  public T getData() {
    return data;
  }

  public void setData(T data) {
    this.data = data;
  }
}
