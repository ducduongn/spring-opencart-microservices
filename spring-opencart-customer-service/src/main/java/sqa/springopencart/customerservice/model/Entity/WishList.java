package sqa.springopencart.customerservice.model.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sqa.springopencartproductservice.model.Entity.Product;

import javax.persistence.*;
import java.util.Set;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "wishlist")
public class WishList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customerId")
    private Integer customerId;

    @OneToOne
    @PrimaryKeyJoinColumn(name = "customerId", foreignKey = @ForeignKey(name = "WISHLIST_FK_CUSTOMER"))
    private Customer customer;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "wishLists")
    private Set<Product> products;

    @Column(name = "status")
    private String status;
}
