package lamph11.shop.dto.category;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryUpdate {

    @NotNull
    private Long id;
    @NotBlank(message = "name can not be null")
    private String name;
    @NotNull
    private Integer status;
    @Min(1)
    private Long parentId;
}
