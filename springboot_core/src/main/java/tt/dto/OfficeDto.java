package tt.dto;

import lombok.Data;

/**
 * @Version
 * @Author tan.jie
 * @Created 2019年10月15  11:06:39
 * @Description <p>
 * @Modification <p>
 * Date Author Version Description
 * <p>
 * 2019年10月15  JerryTan  create file
 */
@Data
public class OfficeDto {
    private String id;
    private String parentId;
    private String parentIds;
    private String name;
}
