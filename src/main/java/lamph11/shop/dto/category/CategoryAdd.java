package lamph11.shop.dto.category;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Data
public class CategoryAdd {

    @NotBlank(message = "name can not be null")
    private String name;
    @Min(1)
    private Long parentId;
}
