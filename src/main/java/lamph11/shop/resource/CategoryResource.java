package lamph11.shop.resource;

import lamph11.shop.common.ApiRequest;
import lamph11.shop.common.ApiResponse;
import lamph11.shop.dto.category.CategoryAdd;
import lamph11.shop.service.CategoryService;
import lamph11.shop.service.dto.CategoryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/category")
public class CategoryResource {

    @Autowired
    private CategoryService categoryService;


    @PostMapping
    public ResponseEntity<ApiResponse<CategoryDTO>> create(
            @RequestBody ApiRequest<CategoryAdd> request
    ){
        try{
            CategoryAdd requestBody = request.getBody();
            CategoryDTO categoryDTO = categoryService.create(requestBody);
            return ResponseEntity.ok(
                    new ApiResponse<>(categoryDTO)
            );
        }catch (Exception e){
            return ResponseEntity
                    .badRequest()
                    .body(ApiResponse.fromException(e));
        }
    }
}
