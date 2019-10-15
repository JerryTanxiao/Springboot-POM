package tt.controller;

import com.google.common.collect.Lists;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import tt.dto.OfficeDto;
import tt.pojo.Office;
import tt.service.OfficeService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

/**
 * <p> 机构表 前端控制器 </p> @author Jerry @since 2019-10-14
 */
@Api(tags = "Office控制层")
@Controller
@RequestMapping("/office")
public class OfficeController {
    @Autowired
    private OfficeService officeService;
    @GetMapping("/treeData")
    @ApiOperation(value = "机构树形数据")
    @ResponseBody
    public List<OfficeDto> getOffice(){
        List<Office> list = officeService.list();
        List<OfficeDto> officeDaoList= Lists.newArrayList();
        OfficeDto officeDto=null;
        for (Office office : list) {
            officeDto= new OfficeDto();
            BeanUtils.copyProperties(office,officeDto);
            officeDaoList.add(officeDto);
        }
        return officeDaoList;
    }

    @GetMapping("/officeView")
    @ApiOperation(value = "机构树")
    public String office(){
        return "office";
    }

    @GetMapping("/getId")
    @ApiOperation(value = "获取单个机构")
    @ResponseBody
    public Office getId(@RequestParam(required = false)String id){
        return officeService.getById(id);
    }
}
