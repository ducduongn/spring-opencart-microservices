package sqa.springopencartproductservice.model.Repository;

import sqa.springopencartproductservice.model.Entity.Product;

import java.util.Collection;

public interface ProductRepository {
    Collection<Product> findAllProduct();

    Collection<Product> findByName(String name);

    Product findById(int ID);

    public void add(Product product);

    public void save(Product product);

    public void deleteById(Integer ID);

    void addToCart(int productID, int customerID);

    void addToWishList(int productID, int customerID);
}
