package tt.service.Impl;

import tt.dao.OfficeDao;
import tt.pojo.Office;
import tt.service.OfficeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 机构表 服务实现类
 * </p>
 *
 * @author Jerry
 * @since 2019-10-14
 */
@Service
public class OfficeServiceImpl extends ServiceImpl<OfficeDao, Office> implements OfficeService {

}
