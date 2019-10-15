package tt.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Mapper层 @author Jerry @date  2019-10-12
 */
@Data
@TableName("t_user")
@ApiModel(value = "User对象", description = "")
public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "Id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    @ApiModelProperty(value = "姓名")
    @TableField("name")
    private String name;
}