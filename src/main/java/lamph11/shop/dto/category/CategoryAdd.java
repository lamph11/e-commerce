package lamph11.shop.dto.category;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class CategoryAdd {

    @NotEmpty
    private String name;
    @NotEmpty
    private Integer parentId;
}
