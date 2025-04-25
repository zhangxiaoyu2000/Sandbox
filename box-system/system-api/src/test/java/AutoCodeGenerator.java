import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.DbColumnType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import com.baomidou.mybatisplus.generator.engine.VelocityTemplateEngine;

import java.sql.Types;
import java.util.ArrayList;
import java.util.Collections;

/**
 * @program: box-system
 * @description: mybatisplus逆向工程类
 * @author: zhangxiaoyu
 * @create: 2025-04-25 19:06
 **/
class AutoCodeGenerator {
    public static void main(String[] args) {
        String projectPath = System.getProperty("user.dir"); // 当前为 system-api 模块路径

        FastAutoGenerator.create(
                        "jdbc:mysql://localhost:3306/sandbox?useUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai",
                        "root",
                        "123456"
                )
                .globalConfig(builder -> {
                    builder.author("baomidou")
                            .enableSwagger()
                            .outputDir("C:\\Users\\张小鱼\\Desktop\\sandbox-master\\Sandbox\\box-system\\common" + "/src/main/java") // 输出到 common 模块
                            .disableOpenDir();
                })
                .dataSourceConfig(builder ->
                        builder.typeConvertHandler((globalConfig, typeRegistry, metaInfo) -> {
                            int typeCode = metaInfo.getJdbcType().TYPE_CODE;
                            if (typeCode == Types.SMALLINT) {
                                return DbColumnType.INTEGER;
                            }
                            return typeRegistry.getColumnType(metaInfo);
                        })
                )
                .packageConfig(builder -> {
                    builder.parent("org.readcom")  // 替换成你自己的包名
                            .moduleName("") // 不建议用 moduleName，否则包名结构多一层
                            .pathInfo(Collections.singletonMap(
                                    OutputFile.xml,
                                    projectPath + "/src/main/resources/mapper"
                            ));
                })
                .strategyConfig(builder -> {
                    builder.addInclude("roles","user") // 生成的表
//                            .addTablePrefix("t_", "c_")
                            .entityBuilder().enableLombok(); // 使用 Lombok
                })
                .templateEngine(new VelocityTemplateEngine()) // 也可以换回 Velocity
                .execute();
    }
}
