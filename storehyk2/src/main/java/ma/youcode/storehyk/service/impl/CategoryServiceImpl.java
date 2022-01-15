package ma.youcode.storehyk.service.impl;

import ma.youcode.storehyk.model.Category;
import ma.youcode.storehyk.repository.CategoryRepository;
import ma.youcode.storehyk.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    CategoryRepository categoryRepository;

    public List<Category> getAllCategory(){
        return categoryRepository.findAll();
    }//findAll

    public void updateCategory(Category category){categoryRepository.save(category); }//add or update

    public void removeCategoryById(int id){
        categoryRepository.deleteById(id);
    }//delete

    public Optional<Category> getCategoryById(int id){
        return categoryRepository.findById(id);
    }//search by id

}

