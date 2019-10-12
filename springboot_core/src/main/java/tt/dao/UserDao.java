package tt.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import tt.pojo.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Jerry
 * @since 2019-10-12
 */
@Mapper
public interface UserDao extends BaseMapper<User> {
    User getUserByUserId(@Param("id") Integer id);
}
