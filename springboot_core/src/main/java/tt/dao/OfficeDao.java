package tt.dao;

import org.apache.ibatis.annotations.Mapper;
import tt.pojo.Office;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * 机构表 Mapper 接口
 * </p>
 *
 * @author Jerry
 * @since 2019-10-14
 */
@Mapper
public interface OfficeDao extends BaseMapper<Office> {

}
