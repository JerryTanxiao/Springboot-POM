package tt;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import tt.dao.UserDao;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootCoreApplicationTests {
    @Autowired
    private UserDao userDao;
    @Test
    public void contextLoads() {
        System.out.println(userDao.selectById(1));
    }

}
