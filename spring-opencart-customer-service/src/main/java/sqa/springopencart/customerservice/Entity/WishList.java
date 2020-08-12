package sqa.springopencart.customerservice.Entity;

import sqa.springopencartproductservice.Entity.Product;

import javax.persistence.*;
import java.util.Set;

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

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public WishList() {
    }
}
