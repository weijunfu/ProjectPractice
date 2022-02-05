package org.ijunfu;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import com.baomidou.mybatisplus.generator.fill.Property;
import net.bytebuddy.implementation.bytecode.Throw;
import org.ijunfu.entity.BaseEntity;

import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @Title          <Title>
 * @Description    <TODO>
 *
 * @author weijunfu<ijunfu @ 1 6 3 . com>
 * @date 2022/02/05 00:35
 * @version 1.0.0
 *
 */

public class CodeGenerator {

    // 数据源配置
    private final static DataSourceConfig.Builder DATA_SOURCE_CONFIG = new DataSourceConfig.Builder("jdbc:h2:file:~/authoritySystem;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE;CASE_INSENSITIVE_IDENTIFIERS=TRUE;MODE=MYSQL", "sa", "");

    private static String scanner(String tip) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder help = new StringBuilder();
        help.append(tip).append(": ");

        System.out.println(help);
        if(scanner.hasNext()) {
            String ipt = scanner.next();
            if(StringUtils.isNotBlank(ipt))
                return ipt;
        }

        throw new MybatisPlusException("输入错误! ");
    }

    public static void main(String[] args) {
        String root = System.getProperty("user.dir");

        while(true) {
            String tables = scanner("请输入表名（多个表使用英文逗号分隔）");

            String flag = scanner("是否继承基类（Y/N）");

            FastAutoGenerator.create(DATA_SOURCE_CONFIG)
                    .globalConfig(builder -> {
                        builder.author("ijunfu")                // 作者
                                .commentDate("yyyy-MM-dd HH:mm")    // 时间格式
                                //                            .enableSwagger()                // 开启 swagger
                                .fileOverride()                 // 覆盖文件
                                .outputDir(root + "/src/main/java")    // 输出目录
                                //                            .dateType(DateType.TIME_PACK)   // 时间类型
                                .disableOpenDir()               // 禁止打开输出目录
                        ;
                    })
                    .packageConfig(builder -> {
                        builder.parent("org.ijunfu")        // 父包名
                                .pathInfo(Collections.singletonMap(OutputFile.mapperXml, root +"/src/main/resources/mapper"))   // Mapper XML输出目录
                        ;
                    })
                    .templateConfig(builder -> {
                        builder.entity("/templates/entity.java")
                                .mapper("/templates/mapper.java")
                                .service("/templates/service.java")
                                .serviceImpl("/templates/serviceImpl.java")
                                .controller("/templates/controller.java")
                                ;
                    })
                    .strategyConfig(builder -> {
                        builder.addInclude(tables.split(","))           // 表名
                                .enableCapitalMode()
                                .enableSkipView()
                                .addTablePrefix("tb_")
                        ;

                        builder.controllerBuilder()
                                .enableRestStyle()
                                .enableHyphenStyle()
                        ;

                        builder.mapperBuilder()
                                .enableMapperAnnotation();

                        builder.entityBuilder()
                                .enableLombok()
                                .idType(IdType.ASSIGN_ID)
                                .logicDeleteColumnName("deleted")   // 逻辑删除字段
                                .addTableFills(new Property("createTime", FieldFill.INSERT))            // 字段填充
                                .addTableFills(new Property("createdBy", FieldFill.INSERT))             // 字段填充
                                .addTableFills(new Property("lastUpdateTime", FieldFill.INSERT_UPDATE)) // 字段填充
                                .addTableFills(new Property("lastUpdatedBy", FieldFill.INSERT_UPDATE))  // 字段填充
                        ;

                        if("Y".equalsIgnoreCase(flag)) {
                            builder.entityBuilder()
                                    .superClass(BaseEntity.class)
                                    .addSuperEntityColumns("deleted", "create_time", "created_by", "last_update_time", "last_updated_by")
                            ;
                        }

                    })
                    .templateEngine(new FreemarkerTemplateEngine())
                    .execute();
        }
    }
}
