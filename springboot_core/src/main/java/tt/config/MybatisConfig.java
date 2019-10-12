package tt.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Component;

/**
 * @Version 0.1
 * @Author tan.jie
 * @Created 2019年10月12  13:55:22
 * @Description <p>
 * @Modification <p>
 * Date Author Version Description
 * <p>
 * 2019年10月12  JerryTan 0.1 create file
 */
@Component
@MapperScan(basePackages = "tt.dao")
public class MybatisConfig {
}
