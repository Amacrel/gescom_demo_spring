package amacrel.gescom_demo_spring.controller;

import amacrel.gescom_demo_spring.dao.CategoryDao;
import amacrel.gescom_demo_spring.entities.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/categories")
public class CategoryController {
    @Autowired
    private CategoryDao categoryDao;

    @GetMapping("/all")
    public String getAll(Model model) {
        model.addAttribute("listCategory", categoryDao.getAllCategories());
        return "categoryView";
    }

    @GetMapping("/delete")
    public String deleteCategory(int id, Model model) {
        if (id != 0) {
            Category cat = this.categoryDao.getCategoryById(id);
            this.categoryDao.deleteCategory(cat);
        }
        return "redirect:/categories/all";
    }

    @GetMapping("/showForm")
    public String showCategory(Model model) {
        model.addAttribute("category",new Category());
        return "category-form";
    }

    @PostMapping(value ="/create", produces = "application/x-www-form-urlencoded")
    public String createCategory(@RequestBody Category category) {

        if (category != null && !category.getName().equals("")) {
            this.categoryDao.addCategory(category);
        }

        return "redirect:/categories/all";
    }

    @GetMapping("/showUpdateForm")
    public String showUpdateForm(int id, Model model) {
        if (id != 0) {
            Category cat = this.categoryDao.getCategoryById(id);
            model.addAttribute("category", cat);
        }
        return "category-form-update";
    }

    @PostMapping("/update_cat")
    public String updateCategory(Category category) {
        if (category != null && !category.getName().equals("")) {
            this.categoryDao.updateCategory(category);
        }
        return "redirect:/categories/all";
    }

//    @PostMapping("/update/{id}")
//    void createOrSaveCategory(@RequestBody Category newCategory) {
//        this.categoryDao.addCategory(newCategory);
//    }

}
