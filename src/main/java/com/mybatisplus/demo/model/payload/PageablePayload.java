package com.mybatisplus.demo.model.payload;

import java.util.Collection;

/**
 * 参数，list, pageNo, pageSize, totalItems
 *
 * @author hezhijun
 * @param <T>
 */
public class PageablePayload<T> extends AbstractPayload {

  private Collection<T> data;
  private Integer pageNo;
  private Integer pageSize;
  private Long totalItems;

  public Collection<T> getData() {
    return data;
  }

  public void setData(Collection<T> data) {
    this.data = data;
  }

  public Integer getPageNo() {
    return pageNo;
  }

  public void setPageNo(Integer pageNo) {
    this.pageNo = pageNo;
  }

  public Integer getPageSize() {
    return pageSize;
  }

  public void setPageSize(Integer pageSize) {
    this.pageSize = pageSize;
  }

  public Long getTotalItems() {
    return totalItems;
  }

  public void setTotalItems(Long totalItems) {
    this.totalItems = totalItems;
  }

  public PageablePayload(Collection<T> data) {
    this(data, 1, data.size(), (long) data.size());
  }

  public PageablePayload(Collection<T> data, Integer pageNo, Integer pageSize, Long totalItems) {
    this(null, null, data, pageNo, pageSize, totalItems);
  }

  public PageablePayload(
      Integer code,
      String message,
      Collection<T> data,
      Integer pageNo,
      Integer pageSize,
      Long totalItems) {
    super(code, message);
    this.pageNo = pageNo;
    this.pageSize = pageSize;
    this.totalItems = totalItems;
    this.data = data;
  }
}
