package amacrel.gescom_demo_spring.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "category")
public class Category implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_category")
    private int idCategory;
    @Column(name = "name_category")

    private String name;

    public Category(String name, int idCategory) {
    }

    public Category() {

    }

    public int getIdCategory() {
        return idCategory;
    }

    public String getName() {
        return name;
    }

    public void setIdCategory(int idCategory) {
        this.idCategory = idCategory;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
