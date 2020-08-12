package sqa.springopencartproductservice.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.format.annotation.DateTimeFormat;
import sqa.springopencart.customerservice.Entity.Cart;
import sqa.springopencart.customerservice.Entity.WishList;

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

    public Product() {
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public Set<Category> getCategories() {
        return categories;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }

    public Set<WishList> getWishLists() {
        return wishLists;
    }

    public void setWishLists(Set<WishList> wishLists) {
        this.wishLists = wishLists;
    }

    public Set<Cart> getCarts() {
        return carts;
    }

    public void setCarts(Set<Cart> carts) {
        this.carts = carts;
    }

    public Set<OrderDetail> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(Set<OrderDetail> orderDetails) {
        this.orderDetails = orderDetails;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(String dateAdded) {
        this.dateAdded = dateAdded;
    }

    public String getDateModified() {
        return dateModified;
    }

    public void setDateModified(String dateModified) {
        this.dateModified = dateModified;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
