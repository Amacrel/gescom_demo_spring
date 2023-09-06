package amacrel.gescom_demo_spring.rest;

import amacrel.gescom_demo_spring.dao.CategoryDao;
import amacrel.gescom_demo_spring.entities.Category;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/categories")
public class CategoryControllerRest {

    private CategoryDao categoryDao;

    public CategoryControllerRest(CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }

    @GetMapping("/all")
    public List<Category> getAllCategories() {
        return this.categoryDao.getAllCategories();
    }

    @PostMapping("/create_category")
    public void addCategory(@RequestBody Category category) {
        this.categoryDao.addCategory(category);
    }
}
