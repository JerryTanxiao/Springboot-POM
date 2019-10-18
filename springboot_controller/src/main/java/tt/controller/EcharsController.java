package tt.controller;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.Data;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * @Version
 * @Author tan.jie
 * @Created 2019年10月18  10:42:04
 * @Description <p>
 * @Modification <p>
 * Date Author Version Description
 * <p>
 * 2019年10月18  JerryTan  create file
 */
@Api(tags = "Echars测试")
@Controller
public class EcharsController {
    @RequestMapping(value = "/EcharsShow")
    @ResponseBody
    @ApiOperation(value = "跳转页面")
    public List<Echars> findById(Model model) {
        List<Echars> list = new ArrayList<Echars>();
        list.add(new Echars("帽子",50));
        list.add(new Echars("鞋子",126));
        list.add(new Echars("毛衣",75));
        list.add(new Echars("羽绒服",201));
        list.add(new Echars("羊毛衫",172));
        return list;
    }

    @GetMapping(value = "/Echars")
    @ApiOperation(value = "跳转页面")
    public String echarts4(Model model){
        System.err.println("========开始");
        return "echars";
    }
    @GetMapping(value = "/Echars1")
    @ApiOperation(value = "跳转页面")
    public String echarts(Model model){
        System.err.println("========开始");
        return "echars1";
    }


}
@Data
class Echars {
    private String name;
    private Integer num;

    public Echars(String name, Integer num) {
        super();
        this.name = name;
        this.num = num;
    }
}
