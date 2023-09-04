package amacrel.gescom_demo_spring;

import amacrel.gescom_demo_spring.dao.CategoryDao;
import amacrel.gescom_demo_spring.entities.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GescomDemoSpringApplication implements CommandLineRunner {
	@Autowired
	private CategoryDao categoryDao;

	public static void main(String[] args) {

		SpringApplication.run(GescomDemoSpringApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {
		this.categoryDao.addCategory(new Category("Livre", 0));
		this.categoryDao.addCategory(new Category("Ordinateur", 0));
		this.categoryDao.addCategory(new Category("Jeux", 0));
		this.categoryDao.addCategory(new Category("DVD", 0));
	}
}
