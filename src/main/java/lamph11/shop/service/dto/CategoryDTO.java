package lamph11.shop.service.dto;

import lamph11.shop.entity.Category;
import lombok.Data;

@Data
public class CategoryDTO {

    private Long id;
    private String name;
    private Integer status;
    private Category parent;
    private Integer parentId;
}
