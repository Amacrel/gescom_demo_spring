package amacrel.gescom_demo_spring.controller;

import amacrel.gescom_demo_spring.dao.ProductDao;
import amacrel.gescom_demo_spring.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping(value = "products", produces = {MediaType.APPLICATION_JSON_VALUE})
public class ProductController {
    @Autowired
    private ProductDao productDao;

    @GetMapping(value = "/")
    public List<Product> getAllProducts() {
        return this.productDao.getAllProducts();
    }
    @GetMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<Product> getProductById(Integer id) {
        Optional<Product> product = Optional.ofNullable(this.productDao.getProductById(id));

        return product.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping()
    void createOrSaveProduct(@RequestBody Product newProduct) {
        this.productDao.addProduct(newProduct);
    }

    @DeleteMapping("/{id}")
    void deleteProductById(@PathVariable Long id) {
        this.productDao.deleteProductById(id);
    }

    @DeleteMapping()
    void deleteProduct(@RequestBody Product product) {
        this.productDao.deleteProduct(product);
    }
}
