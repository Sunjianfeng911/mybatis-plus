package com.mybatisplus.demo;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.FileOutConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.TemplateConfig;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import java.util.ArrayList;
import java.util.List;

public class CodeGenerator {

  // **********************************************************************************
  private static String[] TABLES = new String[] {"house_base_info", "people_base_info"};
  // **********************************************************************************
  // todo:JDBC配置，请修改为你项目的实际配置
  private static final String JDBC_URL =
      "jdbc:p6spy:mysql://47.103.100.82:3306/mybatis-plus?serverTimeZone=Shanghai&useUnicode=true&characterEncoding=utf-8&useSSL=false";
  private static final String JDBC_USERNAME = "root";
  private static final String JDBC_PASSWORD = "root";
  private static final String JDBC_DIVER_CLASS_NAME = "com.mysql.cj.jdbc.Driver";

  private static final String PROJECT_PATH = System.getProperty("user.dir"); // 项目在硬盘上的基础路径

  private static final String JAVA_PATH = "/src/main/java"; // java文件路径
  private static final String JAVA_OUTPUT_PATH = PROJECT_PATH + JAVA_PATH; // 文件路径
  private static final String RESOURCES_PATH = "/src/main/resources"; // 资源文件路径
  private static final String PACKAGE_PARENT = "com.mybatisplus.demo"; // 类父文件夹
  private static final String ENTITY_NAME = "model"; // 实体文件夹名称
  private static final String SERVICE_NAME = "service"; // service文件夹

  private static final String PACKAGE_PATH_MAPPER = "/src/main/resources/mapper/"; // 生成的存放路径

  private static final String AUTHOR = "Sun"; // @author

  public static void main(String[] args) {
    String[] tables = new String[] {"people_test", "user"};
    // 代码生成器
    AutoGenerator mpg = new AutoGenerator();

    // 全局配置
    GlobalConfig gc = new GlobalConfig();
    gc.setOutputDir(JAVA_OUTPUT_PATH);
    gc.setAuthor(AUTHOR);
    gc.setOpen(false);
    gc.setSwagger2(true); // 实体属性 Swagger2 注解
    gc.setBaseResultMap(true); // 自动ResultMap
    gc.setServiceName("%sService"); // 替换默认生成Service名称
    gc.setFileOverride(true); // 是否覆盖原文件
    // gc.setActiveRecord(true);

    mpg.setGlobalConfig(gc);

    // 数据源配置
    DataSourceConfig dsc = new DataSourceConfig();
    dsc.setDbType(DbType.MYSQL);
    dsc.setUrl(JDBC_URL);
    // dsc.setSchemaName("public");
    dsc.setDriverName(JDBC_DIVER_CLASS_NAME);
    dsc.setUsername(JDBC_USERNAME);
    dsc.setPassword(JDBC_PASSWORD);
    mpg.setDataSource(dsc);

    // 包配置
    PackageConfig pc = new PackageConfig();
    pc.setModuleName("");
    pc.setParent(PACKAGE_PARENT);
    pc.setEntity(ENTITY_NAME);
    pc.setService(SERVICE_NAME);
    mpg.setPackageInfo(pc);

    // 自定义配置
    InjectionConfig cfg =
        new InjectionConfig() {
          @Override
          public void initMap() {
            // to do nothing
          }
        };

    // 如果模板引擎是 freemarker
    String templatePath = "/templates/mapper.xml.ftl";
    // 如果模板引擎是 velocity
    // String templatePath = "/templates/mapper.xml.vm";

    // 自定义输出配置
    List<FileOutConfig> focList = new ArrayList<>();
    // 自定义配置会被优先输出
    focList.add(
        new FileOutConfig(templatePath) {
          @Override
          public String outputFile(TableInfo tableInfo) {
            // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
            return PROJECT_PATH
                + PACKAGE_PATH_MAPPER
                + pc.getModuleName()
                + "/"
                + tableInfo.getEntityName()
                + "Mapper"
                + StringPool.DOT_XML;
          }
        });

    cfg.setFileOutConfigList(focList);
    mpg.setCfg(cfg);

    // 配置模板
    TemplateConfig templateConfig = new TemplateConfig();

    // 配置自定义输出模板
    // 指定自定义模板路径，注意不要带上.ftl/.vm, 会根据使用的模板引擎自动识别
    // templateConfig.setEntity("templates/entity2.java");
    // templateConfig.setService();
    // templateConfig.setController("templates/controller.java");
    // 不需要在此路径生成xml
    templateConfig.setXml(null);
    mpg.setTemplate(templateConfig);

    // 策略配置
    StrategyConfig strategy = new StrategyConfig();
    strategy.setNaming(NamingStrategy.underline_to_camel);
    strategy.setColumnNaming(NamingStrategy.underline_to_camel);
    // strategy.setSuperEntityClass("com.baomidou.ant.common.BaseEntity");
    strategy.setEntityLombokModel(true);
    strategy.setRestControllerStyle(true);
    // 公共父类
    // strategy.setSuperControllerClass("com.baomidou.ant.common.BaseController");
    // 写于父类中的公共字段
    // strategy.setSuperEntityColumns("id");
    strategy.setRestControllerStyle(true);

    /** 将需要生成的表填入数组 */
    strategy.setInclude(TABLES);

    //
    strategy.setControllerMappingHyphenStyle(true);
    // 是否生成字段注解
    strategy.setEntityTableFieldAnnotationEnable(true);

    // 表前缀
    // strategy.setTablePrefix(pc.getModuleName() + "_");
    mpg.setStrategy(strategy);
    mpg.setTemplateEngine(new FreemarkerTemplateEngine());
    mpg.execute();
  }
}
