package lamph11.shop.service;

import lamph11.shop.dto.category.CategoryAdd;
import lamph11.shop.entity.Category;
import lamph11.shop.repository.CategoryRepository;
import lamph11.shop.service.dto.CategoryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class CategoryService{

    @Autowired
    private CategoryRepository categoryRepository;


    public CategoryDTO create(CategoryAdd dto){
        Category category = new Category();
        return null;
    }
}
