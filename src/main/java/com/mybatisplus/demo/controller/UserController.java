package com.mybatisplus.demo.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mybatisplus.demo.model.User;
import com.mybatisplus.demo.model.payload.EntityPayload;
import com.mybatisplus.demo.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户表 前端控制器
 *
 * @author Sun
 * @since 2019-12-02
 * @version v1.0
 */
@Api(tags = {"用户表"})
@Slf4j
@RestController
@RequestMapping("//user")
public class UserController {
  @Autowired private UserService userService;

  /** 查询分页数据 */
  @ApiOperation(value = "查询分页数据")
  @GetMapping(value = "/list")
  public EntityPayload<IPage<User>> findListByPage(
      @RequestParam(name = "pageNum", defaultValue = "1") int pageNum,
      @RequestParam(name = "pageSize", defaultValue = "20") int pageSize,
      User user) {
    IPage<User> page = new Page<>(pageNum, pageSize);
    QueryWrapper<User> wrapper = new QueryWrapper(user);
    return new EntityPayload<>(userService.page(page, wrapper));
  }

  /** 根据id查询 */
  @ApiOperation(value = "根据id查询数据")
  @GetMapping(value = "/{id}")
  public EntityPayload<User> getById(@PathVariable String id) {
    return new EntityPayload<>(userService.getById(id));
  }

  /** 新增 */
  @ApiOperation(value = "新增数据")
  @PostMapping(value = "/")
  public EntityPayload<User> add(@RequestBody User user) {
    userService.save(user);
    return new EntityPayload<>(user);
  }
  /** 删除 */
  @ApiOperation(value = "删除数据")
  @DeleteMapping(value = "/{id}")
  public EntityPayload<String> delete(@PathVariable String id) {
    userService.removeById(id);

    return new EntityPayload<>("ok");
  }
  /** 删除 */
  @ApiOperation(value = "删除数据")
  @DeleteMapping(value = "/")
  public EntityPayload<String> delete(@RequestParam("ids") List<String> ids) {
    userService.removeByIds(ids);
    return new EntityPayload<>("ok");
  }

  /** 修改 */
  @ApiOperation(value = "更新数据")
  @PutMapping(value = "/{id}")
  public EntityPayload<User> update(@PathVariable String id, @RequestBody User user) {
    userService.updateById(user);
    return new EntityPayload<>(user);
  }
}
