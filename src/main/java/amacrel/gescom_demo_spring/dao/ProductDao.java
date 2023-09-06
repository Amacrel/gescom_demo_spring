package amacrel.gescom_demo_spring.dao;

import amacrel.gescom_demo_spring.entities.Category;
import amacrel.gescom_demo_spring.entities.Product;
import amacrel.gescom_demo_spring.repository.ProductRepository;
import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductDao {
    @Autowired
    private ProductRepository productRepository;
    public List<Product> getAllProducts() {
        return this.productRepository.findAll();
    };
    public Product getProductById(@NotNull Integer productId) {
        if (this.productRepository.findById(productId).isPresent()) {
            return this.productRepository.findById(Math.toIntExact(productId)).get();
        } else {
            return null;
        }
    }
    public void addProduct(Product product) {
        this.productRepository.save(product);
    }

    public void deleteProduct(Product product) {
        this.productRepository.delete(product);
    }
    public void deleteProductById(Long productId) {
        this.productRepository.deleteById(Math.toIntExact(productId));
    }


    public void updateCategory(Product product) {
        this.productRepository.save(product);
    }
}
