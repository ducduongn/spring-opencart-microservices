package sqa.springopencart.customerservice.model.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import sqa.springopencartproductservice.model.Entity.Product;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cart")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customerId")
    private Integer customerId;

    @OneToOne
    @PrimaryKeyJoinColumn(name = "customerId", foreignKey = @ForeignKey(name = "CART_FK_CUSTOMER"))
    private Customer customer;

    //27/7/20
    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "carts")
    private Set<Product> products;

    @Column(name = "dateAdded")
    @DateTimeFormat(pattern = "mm/dd/yyyy")
    private String dateAdded;

    @Column(name = "quantity")
    private int quantity;

}
