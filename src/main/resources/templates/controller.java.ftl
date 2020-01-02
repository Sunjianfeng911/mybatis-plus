package ${package.Controller};


import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.mybatisplus.demo.service.${table.serviceName};
import com.mybatisplus.demo.model.${entity};
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mybatisplus.demo.model.base.Result;
import java.util.List;
<#if restControllerStyle>
  import org.springframework.web.bind.annotation.RestController;
<#else>
  import org.springframework.stereotype.Controller;
</#if>
<#if superControllerClassPackage??>
  import ${superControllerClassPackage};
</#if>

/**
* <p>
  * ${table.comment!} 前端控制器
  * </p>
*
* @author ${author}
* @since ${date}
* @version v1.0
*/
<#if restControllerStyle>
  @Api(tags = {"${table.comment!}"})
  @Slf4j
  @RestController
<#else>
  @Controller
</#if>
@RequestMapping("<#if package.ModuleName??>/${package.ModuleName}</#if>/<#if controllerMappingHyphenStyle??>${controllerMappingHyphen}<#else>${table.entityPath}</#if>")
<#if kotlin>
class ${table.controllerName}<#if superControllerClass??> : ${superControllerClass}()</#if>
<#else>
<#if superControllerClass??>
  public class ${table.controllerName} extends ${superControllerClass} {
<#else>
  public class ${table.controllerName} {
</#if>
@Autowired
private ${table.serviceName} ${(table.serviceName)?uncap_first};

/**
* 查询分页数据
*/
@ApiOperation(value = "查询分页数据")
@GetMapping(value = "/list")
public Result
<IPage<${entity}>> findListByPage(@RequestParam(name = "pageNum", defaultValue = "1") int
pageNum,@RequestParam(name = "pageSize", defaultValue = "20") int pageSize,${entity} ${entity?uncap_first}){
IPage
<${entity}> page = new Page<>(pageNum,pageSize);
QueryWrapper
<${entity}> wrapper = new QueryWrapper(${entity?uncap_first});
return new Result<>(${(table.serviceName)?uncap_first}.page(page, wrapper));
}


/**
* 根据id查询
*/
@ApiOperation(value = "根据id查询数据")
@GetMapping(value = "/{id}")
public Result<${entity}> getById(@PathVariable String id){
return new Result<>( ${(table.serviceName)?uncap_first}.getById(id));
}

/**
* 新增
*/
@ApiOperation(value = "新增数据")
@PostMapping(value = "/")
public Result<${entity}> add(@RequestBody ${entity} ${entity?uncap_first}){
${(table.serviceName)?uncap_first}.save(${entity?uncap_first});
return new Result<>(${entity?uncap_first});
}
/**
* 删除
*/
@ApiOperation(value = "删除数据")
@DeleteMapping(value = "/{id}")
public Result
<String> delete(@PathVariable String id){
  ${(table.serviceName)?uncap_first}.removeById(id);

  return new Result<>();
  }
  /**
  * 批量删除
  */
  @ApiOperation(value = "删除数据")
  @DeleteMapping(value = "/")
  public Result
  <String> delete(@RequestParam("ids") List
    <String> ids){
      ${(table.serviceName)?uncap_first}.removeByIds(ids);
      return new Result<>();
      }

      /**
      * 修改
      */
      @ApiOperation(value = "更新数据")
      @PutMapping(value = "/{id}")
      public Result<${entity}> update( @PathVariable String id,
      @RequestBody ${entity} ${entity?uncap_first}){
      ${(table.serviceName)?uncap_first}.updateById(${entity?uncap_first});
      return new Result<>(${entity?uncap_first});
      }

      }
      </#if>
