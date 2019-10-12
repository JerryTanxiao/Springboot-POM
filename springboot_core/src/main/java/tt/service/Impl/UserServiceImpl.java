package tt.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import tt.pojo.User;
import tt.dao.UserDao;
import tt.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Jerry
 * @since 2019-10-12
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserDao, User> implements UserService {
    @Autowired
    private UserDao userDao;
    @Override
    public User getUserById(Integer id) {
        return userDao.getUserByUserId(id);
    }
}
