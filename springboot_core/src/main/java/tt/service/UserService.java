package tt.service;

import tt.pojo.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Jerry
 * @since 2019-10-12
 */
public interface UserService extends IService<User> {
    public User getUserById(Integer id);
}
