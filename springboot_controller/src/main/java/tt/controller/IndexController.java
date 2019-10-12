package tt.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import tt.service.Impl.UserServiceImpl;

/**
 * @Version 初始化页面
 * @Author tan.jie
 * @Created 2019年10月12  14:42:44
 * @Description <p>
 * @Modification <p>
 * Date Author Version Description
 * <p>
 * 2019年10月12  JerryTan 初始化页面 create file
 */
@Api(tags = "用户管理")
@Controller
public class IndexController {
    @Autowired
    private UserServiceImpl userService;
    @ApiOperation(value = "跳转页面")
    @RequestMapping("/")
    public String index(Model model){
        model.addAttribute("title","Springboot渲染页面");
        model.addAttribute("user",userService.getById(1));
        return "index";
    }
}
