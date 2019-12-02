package com.mybatisplus.demo.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.mybatisplus.demo.model.PeopleTest;
import com.mybatisplus.demo.model.page.Page;
import com.mybatisplus.demo.model.payload.EntityPayload;
import com.mybatisplus.demo.service.PeopleTestService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
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
 * 前端控制器
 *
 * @author Sun
 * @since 2019-12-02
 * @version v1.0
 */
@Api(tags = {""})
@Slf4j
@RestController
@RequestMapping("//people-test")
public class PeopleTestController {
  @Autowired private PeopleTestService peopleTestService;

  /** 查询分页数据 */
  @ApiOperation(value = "查询分页数据")
  @GetMapping(value = "/list")
  public EntityPayload<IPage<PeopleTest>> findListByPage(
      HttpServletRequest request, PeopleTest peopleTest) {
    IPage<PeopleTest> page = new Page<>(request);

    QueryWrapper<PeopleTest> wrapper = new QueryWrapper(peopleTest);

    return new EntityPayload<>(peopleTestService.page(page, wrapper));
  }

  /** 根据id查询 */
  @ApiOperation(value = "根据id查询数据")
  @GetMapping(value = "/{id}")
  public EntityPayload<PeopleTest> getById(@PathVariable String id) {
    return new EntityPayload<>(peopleTestService.getById(id));
  }

  /** 新增 */
  @ApiOperation(value = "新增数据")
  @PostMapping(value = "/")
  public EntityPayload<PeopleTest> add(@RequestBody PeopleTest peopleTest) {
    peopleTestService.save(peopleTest);
    return new EntityPayload<>(peopleTest);
  }
  /** 删除 */
  @ApiOperation(value = "删除数据")
  @DeleteMapping(value = "/{id}")
  public EntityPayload<String> delete(@PathVariable @RequestParam("id") String id) {
    peopleTestService.removeById(id);

    return new EntityPayload<>("ok");
  }
  /** 删除 */
  @ApiOperation(value = "删除数据")
  @DeleteMapping(value = "/")
  public EntityPayload<String> delete(@RequestParam("ids") List<String> ids) {
    peopleTestService.removeByIds(ids);
    return new EntityPayload<>("ok");
  }

  /** 修改 */
  @ApiOperation(value = "更新数据")
  @PutMapping(value = "/{id}")
  public EntityPayload<PeopleTest> update(
      @PathVariable String id, @RequestBody PeopleTest peopleTest) {
    peopleTestService.updateById(peopleTest);
    return new EntityPayload<>(peopleTest);
  }
}
