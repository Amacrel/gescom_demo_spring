package amacrel.gescom_demo_spring.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "product")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Product implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_product")
    private int idProduct;
    @Column(name = "name_product")
    private String nameProduct;
    @Column(name = "description_product")
    private String descriptionProduct;
    @Column(name = "price_product")
    private double priceProduct;
    @Column(name = "stock_product")
    private int stockProduct;
    @Column(name = "image_product")
    private String imageProduct;
    // attribut de type object pour la jointure
    @ManyToOne
    @JoinColumn(name = "")
    private Category categoryJoin;

}
