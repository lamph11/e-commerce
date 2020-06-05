package lamph11.shop.resource;

import lamph11.shop.common.ApiRequest;
import lamph11.shop.common.ApiResponse;
import lamph11.shop.dto.category.CategoryAdd;
import lamph11.shop.dto.category.CategoryUpdate;
import lamph11.shop.service.CategoryService;
import lamph11.shop.service.dto.CategoryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/category")
public class CategoryResource {

    @Autowired
    private CategoryService categoryService;


    @PostMapping
    public ResponseEntity<ApiResponse<CategoryDTO>> create(
            @RequestBody @Valid ApiRequest<CategoryAdd> request
    ){
        try{
            CategoryAdd requestBody = request.getBody();
            CategoryDTO categoryDTO = categoryService.create(requestBody);
            return ResponseEntity.ok(
                    new ApiResponse<>(categoryDTO)
            );
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity
                    .badRequest()
                    .body(ApiResponse.fromException(e));
        }
    }



    @PutMapping
    public ResponseEntity<ApiResponse<CategoryDTO>> update(
            @RequestBody @Valid ApiRequest<CategoryUpdate> request
    ){
        try{
            CategoryUpdate requestBody = request.getBody();
            CategoryDTO categoryDTO = categoryService.update(requestBody);
            return ResponseEntity.ok(
                    new ApiResponse<>(categoryDTO)
            );
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity
                    .badRequest()
                    .body(ApiResponse.fromException(e));
        }
    }
}
