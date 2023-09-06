package amacrel.gescom_demo_spring;

import amacrel.gescom_demo_spring.dao.CategoryDao;
import amacrel.gescom_demo_spring.dao.ProductDao;
import amacrel.gescom_demo_spring.entities.Category;
import amacrel.gescom_demo_spring.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GescomDemoSpringApplication implements CommandLineRunner {
	@Autowired
	private CategoryDao categoryDao;
	@Autowired
	private ProductDao productDao;

	public static void main(String[] args) {

		SpringApplication.run(GescomDemoSpringApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {
		this.categoryDao.addCategory(new Category("Livre", 0));
		this.categoryDao.addCategory(new Category("Ordinateur", 0));
		this.categoryDao.addCategory(new Category("Jeux", 0));
		this.categoryDao.addCategory(new Category("DVD", 0));

		Category category = this.categoryDao.getCategoryById(2);

		this.productDao.addProduct(new Product(0,"Produit 1", "Description 1", 15, 20, "", category));
		this.productDao.addProduct(new Product(0,"Produit 2", "Description 2", 15, 20, "", category));
		this.productDao.addProduct(new Product(0,"Produit 3", "Description 3", 15, 20, "", category));
		this.productDao.addProduct(new Product(0,"Produit 4", "Description 4", 15, 20, "", category));

		Product product2 = this.productDao.getProductById(2);
		System.out.println(product2);
	}
}
