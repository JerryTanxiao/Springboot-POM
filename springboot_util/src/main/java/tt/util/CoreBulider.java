package tt.util;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author JerryTan
 * @Date 2019/10/12 10:43
 * 代码生成
 */
public class CoreBulider {
    /**
     * <p>
     * 读取控制台内容
     * </p>
     */
    public static String scanner(String tip) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder help = new StringBuilder();
        help.append("请输入" + tip + "：");
        System.out.println(help.toString());
        if (scanner.hasNext()) {
            String ipt = scanner.next();
            if (StringUtils.isNotEmpty(ipt)) {
                return ipt;
            }
        }
        throw new MybatisPlusException("请输入正确的" + tip + "！");
    }

    public static void main(String[] args) {
        //代码生成器
        AutoGenerator mpg=new AutoGenerator();
        //全局配置
        GlobalConfig gc=new GlobalConfig();
        String projectPath = System.getProperty("user.dir");
        //要输送的地方
        gc.setOutputDir(projectPath+"/src/main/java");
        gc.setAuthor("Jerry");
        gc.setSwagger2(true);
        gc.setOpen(false);
        gc.setActiveRecord(false);
        gc.setEnableCache(false);
        gc.setBaseResultMap(true);
        gc.setBaseColumnList(false);
        gc.setIdType(IdType.AUTO);
        //自定义文件名,注意%s会自动填充表实体类属性
        gc.setControllerName("%sController");
        gc.setServiceName("%sService");
        gc.setServiceImplName("%sServiceImpl");
        gc.setMapperName("%sDao");
        gc.setXmlName("%sMapper");
        mpg.setGlobalConfig(gc);
        //配置数据源
        DataSourceConfig dsc=new DataSourceConfig();
        dsc.setDbType(DbType.MYSQL);
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        dsc.setUrl("jdbc:mysql://47.106.227.129:3306/db?useUnicode=true&useSSL=false&characterEncoding=utf8&serverTimezone=UTC");
        dsc.setPassword("123456");
        dsc.setUsername("root");
        mpg.setDataSource(dsc);
        //包的配置
        PackageConfig pc=new PackageConfig();
        /*pc.setModuleName(scanner("模块名"));*/
        pc.setParent("tt");
        pc.setController("controller");
        pc.setEntity("pojo");
        pc.setService("service");
        pc.setServiceImpl("service.Impl");
        pc.setMapper("dao");
        pc.setXml("mapper");
        mpg.setPackageInfo(pc);
        //自定义配置
        List<FileOutConfig> focList=new ArrayList<>();
        InjectionConfig cfg=new InjectionConfig() {
            @Override
            public void initMap() {
            }
        };
        mpg.setCfg(cfg);

        focList.add(new FileOutConfig("/vm/controller.java.vm") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                return projectPath+"/springboot_controller"+"/src/main/java/tt/controller/"+tableInfo.getControllerName()+".java";
            }
        });
        //自定义配置会优先输出  设置mapper模板
        focList.add(new FileOutConfig("/vm/mapper.xml.vm") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
                return projectPath+"/springboot_core" + "/src/main/resources/mapper/"+ tableInfo.getEntityName() + "Mapper" + ".xml";
            }
        });
        focList.add(new FileOutConfig("/vm/mapper.java.vm") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
                return projectPath+"/springboot_core" + "/src/main/java/tt/dao/"+tableInfo.getEntityName()+"Dao.java";
            }
        });
        focList.add(new FileOutConfig("/vm/entity.java.vm") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                return projectPath+"/springboot_core"+"/src/main/java/tt/pojo/"+tableInfo.getEntityName()+".java";
            }
        });
        focList.add(new FileOutConfig("/vm/service.java.vm") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                return projectPath+"/springboot_core"+"/src/main/java/tt/service/"+tableInfo.getEntityName()+"Service.java";
            }
        });
        focList.add(new FileOutConfig("/vm/serviceImpl.java.vm") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                return projectPath+"/springboot_core"+"/src/main/java/tt/service/Impl/"+tableInfo.getEntityName()+"ServiceImpl.java";
            }
        });
        focList.add(new FileOutConfig("/vm/serviceImpl.java.vm") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                return projectPath+"/springboot_core"+"/src/main/java/tt/service/Impl/"+tableInfo.getEntityName()+"ServiceImpl.java";
            }
        });
        cfg.setFileOutConfigList(focList);
        //配置模板 如果配置了自定义模板一定要将其设置为空不然会出现两个
        TemplateConfig templateConfig=new TemplateConfig();
        templateConfig.setXml(null);
        templateConfig.setController(null);
        templateConfig.setEntity(null);
        templateConfig.setService(null);
        templateConfig.setServiceImpl(null);
        templateConfig.setMapper(null);
        mpg.setTemplate(templateConfig);
        //策略配置
        StrategyConfig strategy=new StrategyConfig();
        //驼峰命名
        strategy.setNaming(NamingStrategy.underline_to_camel);
        //表前缀用来区分
//        strategy.setTablePrefix("t_");
        strategy.setTablePrefix(scanner("表前缀"));
        strategy.setEntityLombokModel(true);
        //生成RestController控制器
        strategy.setRestControllerStyle(true);
        strategy.setSuperControllerClass(null);
        strategy.setInclude(scanner("表名,多个用英文逗号分隔").split(","));
        strategy.setEntityTableFieldAnnotationEnable(true);
        strategy.setControllerMappingHyphenStyle(true);
        mpg.setStrategy(strategy);
        mpg.execute();
    }
}
