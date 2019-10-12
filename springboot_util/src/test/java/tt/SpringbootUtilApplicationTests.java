package tt;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootUtilApplicationTests {

    @Test
    public void contextLoads() {
        String projectPath = System.getProperty("user.dir");
        System.out.println("user.dir:"+projectPath);
    }


}
