package amacrel.gescom_demo_spring.repository;

import amacrel.gescom_demo_spring.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
    public Category findOneCategoryById(int categoryId);
}
