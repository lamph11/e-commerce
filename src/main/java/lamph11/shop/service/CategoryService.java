package lamph11.shop.service;

import lamph11.shop.common.Status;
import lamph11.shop.dto.category.CategoryAdd;
import lamph11.shop.dto.category.CategoryUpdate;
import lamph11.shop.entity.Category;
import lamph11.shop.repository.CategoryRepository;
import lamph11.shop.service.dto.CategoryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.Optional;


@Service
@Transactional
public class CategoryService{

    @Autowired
    private CategoryRepository categoryRepository;


    /**
     * create category
     * @param dto category dto from request
     * @return category dto saved
     * @throws Exception
     */
    public CategoryDTO create(CategoryAdd dto) throws Exception {
        if(StringUtils.isEmpty(dto))
            throw new Exception("payload can not empty");

        Long parentId = dto.getParentId();
        Category parent = null;
        if(! StringUtils.isEmpty(parentId)){
            parent = categoryRepository.findById(parentId).orElse(null);
        }

        Category category = Category.builder()
                .name(dto.getName())
                .status(1)
                .parent(parent)
                .build();

        categoryRepository.save(category);

        return CategoryDTO.builder()
                .id(category.getId())
                .name(category.getName())
                .status(category.getStatus())
                .build();
    }


    /**
     * update category
     * @param requestBody category update dto from request
     * @return category dto updated
     * @throws Exception
     */
    public CategoryDTO update(CategoryUpdate requestBody) throws Exception {
        if(StringUtils.isEmpty(requestBody))
            throw new Exception("payload can not empty");

        Optional<Category> optionalCategory = categoryRepository.findById(requestBody.getId());
        if( !optionalCategory.isPresent() )
            throw new Exception("category not exists");

        Category category = optionalCategory.get();

        Long parentId = requestBody.getParentId();
        Category parent = null;
        if(! StringUtils.isEmpty(parentId)){
            parent = categoryRepository.findById(parentId).orElse(null);
        }

        category.setParent(parent);
        category.setStatus(requestBody.getStatus());
        categoryRepository.save(category);

        return CategoryDTO.builder()
                .id(category.getId())
                .name(category.getName())
                .status(category.getStatus())
                .build();
    }
}
