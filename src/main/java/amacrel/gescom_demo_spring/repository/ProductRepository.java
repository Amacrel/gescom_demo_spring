package amacrel.gescom_demo_spring.repository;

import amacrel.gescom_demo_spring.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
