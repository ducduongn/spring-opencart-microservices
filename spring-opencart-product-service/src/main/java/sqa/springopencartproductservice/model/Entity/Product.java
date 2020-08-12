package sqa.springopencartproductservice.model.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.format.annotation.DateTimeFormat;
import sqa.springopencart.customerservice.model.Entity.Cart;
import sqa.springopencart.customerservice.model.Entity.WishList;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@EntityScan(basePackages = {"sqa.springopencartproductservice.model.Entity"})
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "productId")
    private Integer productId;

    @ManyToOne
    @JoinColumn(name = "brandid")
    private Brand brand;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "category-product", joinColumns = @JoinColumn(name = "productId"),
            inverseJoinColumns = @JoinColumn(name = "catetogoryId"))
    private Set<Category> categories;


    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "wishlist-product", joinColumns = @JoinColumn(name = "productid"),
            inverseJoinColumns = @JoinColumn(name = "customerid"))
    private Set<WishList> wishLists;


    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "cart-product", joinColumns = @JoinColumn(name = "productid"),
            inverseJoinColumns = @JoinColumn(name = "customerid"))
    private Set<Cart> carts;


    @OneToMany(cascade = CascadeType.ALL, mappedBy = "product", fetch = FetchType.LAZY)
    private Set<OrderDetail> orderDetails;


    @Column(name = "productname")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "dateadded")
    @DateTimeFormat(pattern = "yyyy/mm/dd")
    private String dateAdded;

    @Column(name = "datemodified")
    @DateTimeFormat(pattern = "yyyy/mm/dd")
    private String dateModified;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "priceunit")
    private double price;

}
