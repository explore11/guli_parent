package com.song;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.po.TableFill;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname CodeGenerator
 * @Description 代码生成
 * @Date 2020/8/22 14:30
 * @Created by swq
 */
public class CodeGenerator {
    public static void main(String[] args) {
        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();

        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        String projectPath = System.getProperty("user.dir"); // 生成文件的输出目录【默认 D 盘根目录】
//        gc.setOutputDir(projectPath + "/src/main/java");
        gc.setOutputDir("D:\\workplace\\guli_parent\\service\\service_edu" + "/src/main/java");
        gc.setAuthor("Song");  // 开发人员名字
        gc.setFileOverride(false); // 是否覆盖已有文件
        gc.setOpen(false);  // 是否打开输出目录
        gc.setEnableCache(false); // 否在xml中添加二级缓存配置
        gc.setSwagger2(false); // 开启 swagger2 模式
        gc.setDateType(DateType.ONLY_DATE); //时间类型对应策略   只使用 java.util.date 代替
        gc.setIdType(IdType.ASSIGN_ID); // 指定生成的主键的ID类型
        gc.setServiceName("%sService"); // 去掉IService中的I
        mpg.setGlobalConfig(gc);

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl("jdbc:mysql://182.92.241.248:3306/guli?serverTimezone=Asia/Shanghai&useUnicode=true&characterEncoding=UTF8&useSSL=false");
        dsc.setDriverName("com.mysql.cj.jdbc.Driver"); // mysql驱动 mysql8以后的
        dsc.setUsername("user");
        dsc.setPassword("Songwenqu123,");
        dsc.setDbType(DbType.MYSQL); //数据库类型 mysql
        mpg.setDataSource(dsc);

        // 包配置
        PackageConfig pc = new PackageConfig();
        pc.setParent("com.song"); // 父包名。如果为空，将下面子包名必须写全部， 否则就只需写子包名
        pc.setModuleName("eduservice"); // 父包模块名
        pc.setController("controller"); // Controller包名
        pc.setService("service"); // Service包名
        pc.setServiceImpl("serviceImpl"); // Service Impl包名
        pc.setMapper("mapper"); // Mapper包名
        pc.setXml("mapper.xml"); // Mapper XML包名
        pc.setEntity("entity"); // Entity包名
        mpg.setPackageInfo(pc);

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel); // 数据库表映射到实体的命名策略    下划线转驼峰命名
        strategy.setColumnNaming(NamingStrategy.underline_to_camel); // 数据库表字段映射到实体的命名策略
//        strategy.setSuperEntityClass(); // 设置实体父类 没有就不用设置!
        strategy.setEntityLombokModel(true); // 【实体】是否为lombok模型（默认 false）
        strategy.setRestControllerStyle(true); // 生成 @RestController 控制器
//        strategy.setVersionFieldName("version"); // 乐观锁属性名称
//        strategy.setLogicDeleteFieldName("deleted"); // 逻辑删除属性名称

        // 表填充字段
//        List<TableFill> tableFills = new ArrayList<>();
//        TableFill createTime = new TableFill("createTime", FieldFill.INSERT);
//        TableFill updateTime = new TableFill("updateTime", FieldFill.INSERT);
//        tableFills.add(createTime);
//        tableFills.add(updateTime);
//        strategy.setTableFillList(tableFills);

        // 配置
        strategy.setInclude("edu_teacher"); // 需要包含的表名，允许正则表达式（与exclude二选一配置）<br/>
        strategy.setTablePrefix(pc.getModuleName() + "_");
        strategy.setChainModel(false);// 是否为链式模型
        strategy.setControllerMappingHyphenStyle(false); // 驼峰转连字符
        strategy.setEntityBooleanColumnRemoveIsPrefix(false);  // Boolean类型字段是否移除is前缀  比如 : 数据库字段名称 : 'is_xxx',类型为 : tinyint. 在映射实体的时候则会去掉is,在实体类中映射最终结果为 xxx
        strategy.setEntityColumnConstant(false); // 【实体】是否生成字段常量（默认 false）
        strategy.setEntitySerialVersionUID(true); // 体是否生成 serialVersionUID
        strategy.setEntityTableFieldAnnotationEnable(true); // 是否生成实体时，生成字段注解
        strategy.setSkipView(false); // 是否跳过视图

        mpg.setStrategy(strategy);
        mpg.execute();
    }

}