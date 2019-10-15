package tt.pojo;
import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
@Data
@TableName("sys_office")
@ApiModel(value = "Office对象", description = "机构表")
public class Office {
    @ApiModelProperty(value = "编号")
    @TableId(value = "id", type = IdType.AUTO)
    private String id;
    @ApiModelProperty(value = "父级编号")
    @TableField("parent_id")
    private String parentId;
    @ApiModelProperty(value = "所有父级编号")
    @TableField("parent_ids")
    private String parentIds;
    @ApiModelProperty(value = "名称")
    @TableField("name")
    private String name;
    @ApiModelProperty(value = "排序")
    @TableField("sort")
    private BigDecimal sort;
    @ApiModelProperty(value = "区域编码")
    @TableField("code")
    private String code;
    @ApiModelProperty(value = "机构类型")
    @TableField("type")
    private String type;
    @ApiModelProperty(value = "机构等级")
    @TableField("grade")
    private String grade;
    @ApiModelProperty(value = "联系地址")
    @TableField("address")
    private String address;
    @ApiModelProperty(value = "邮政编码")
    @TableField("zip_code")
    private String zipCode;
    @ApiModelProperty(value = "负责人")
    @TableField("master")
    private String master;
    @ApiModelProperty(value = "电话")
    @TableField("phone")
    private String phone;
    @ApiModelProperty(value = "传真")
    @TableField("fax")
    private String fax;
    @ApiModelProperty(value = "邮箱")
    @TableField("email")
    private String email;
    @ApiModelProperty(value = "是否启用")
    @TableField("USEABLE")
    private String useable;
    @ApiModelProperty(value = "主负责人")
    @TableField("PRIMARY_PERSON")
    private String primaryPerson;
    @ApiModelProperty(value = "副负责人")
    @TableField("DEPUTY_PERSON")
    private String deputyPerson;
    @ApiModelProperty(value = "创建者")
    @TableField("create_by")
    private String createBy;
    @ApiModelProperty(value = "创建时间")
    @TableField("create_date")
    private LocalDateTime createDate;
    @ApiModelProperty(value = "更新者")
    @TableField("update_by")
    private String updateBy;
    @ApiModelProperty(value = "更新时间")
    @TableField("update_date")
    private LocalDateTime updateDate;
    @ApiModelProperty(value = "备注信息")
    @TableField("remarks")
    private String remarks;
    @ApiModelProperty(value = "删除标记")
    @TableField("del_flag")
    private String delFlag;
    @ApiModelProperty(value = "是否是页结点：0不是；1是")
    @TableField("leaf")
    private String leaf;
    @ApiModelProperty(value = "区域等级 1：市级 2：县级")
    @TableField("leveltype")
    private Integer leveltype;
    @ApiModelProperty(value = "共享池key")
    @TableField("sharepoolkey")
    private String sharepoolkey;
    @ApiModelProperty(value = "共享池密钥")
    @TableField("sharepoolsecret")
    private String sharepoolsecret;
    @ApiModelProperty(value = "每日可推荐文章数量")
    @TableField("dailyrecommendnum")
    private Integer dailyrecommendnum;
    @ApiModelProperty(value = "每日已推荐文章数量")
    @TableField("recommendedNum")
    private Integer recommendedNum;
    @ApiModelProperty(value = "来源")
    @TableField("copyfrom")
    private String copyfrom;
    @ApiModelProperty(value = "水印图片")
    @TableField("watermark")
    private String watermark;
    @TableField("appid")
    private String appid;
    @ApiModelProperty(value = "串联单审核级别")
    @TableField("tandemLevel")
    private Integer tandemLevel;
    @ApiModelProperty(value = "uuid")
    @TableField("uuid")
    private String uuid;
}