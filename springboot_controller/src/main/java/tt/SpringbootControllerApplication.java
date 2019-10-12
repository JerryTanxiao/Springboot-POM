package tt;

import com.spring4all.swagger.EnableSwagger2Doc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;

//@SpringBootConfiguration
//@EnableAutoConfiguration
@EnableSwagger2Doc
//@ComponentScan(basePackages = {"tt.dao","tt.service","tt.controller"})
@SpringBootApplication
public class SpringbootControllerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootControllerApplication.class, args);
    }

}
