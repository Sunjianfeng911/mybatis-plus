package com.mybatisplus.demo.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * 用户测试
 *
 * @author Sun
 * @since 2019-12-02
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "PeopleTest对象", description = "用户测试")
public class PeopleTest implements Serializable {

  private static final long serialVersionUID = 1L;

  @ApiModelProperty(value = "主键")
  @TableId("code")
  private String code;

  @ApiModelProperty(value = "名字")
  @TableField("name")
  private String name;

  @ApiModelProperty(value = "手机号")
  @TableField("phone")
  private String phone;

  @ApiModelProperty(value = "爱好")
  @TableField("hobby")
  private String hobby;

  @ApiModelProperty(value = "年龄")
  @TableField("age")
  private Integer age;

  @ApiModelProperty(value = "性别")
  @TableField("sex")
  private String sex;

  @TableField("abc")
  private String abc;

  private transient User user;
}
