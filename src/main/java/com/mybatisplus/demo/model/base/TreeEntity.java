package com.mybatisplus.demo.model.base;

import java.io.Serializable;
import java.util.List;
import lombok.Data;

@Data
public class TreeEntity<T> implements Serializable {

  //    @TableField("pid")
  //    @NotEmpty(message="[父级编号]不能为空")
  //    protected String pid;

  protected transient List<TreeEntity> children;
}
