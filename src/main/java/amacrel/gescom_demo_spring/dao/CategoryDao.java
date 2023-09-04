package amacrel.gescom_demo_spring.dao;

import amacrel.gescom_demo_spring.entities.Category;
import amacrel.gescom_demo_spring.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Component
//@Service
public class CategoryDao {
    @Autowired
    private CategoryRepository categoryRepository;
    public List<Category> getAllCategories() {
        return this.categoryRepository.findAll();
    }

    public Category getCategoryById(int categoryId) {
        return this.categoryRepository.getById(categoryId);
    }
    public void addCategory(Category category) {
        this.categoryRepository.save(category);
    }

    public void deleteCategory(Category category) {
        this.categoryRepository.delete(category);
    }

    public void updateCategory(Category category) {
        this.categoryRepository.save(category);
    }
}
