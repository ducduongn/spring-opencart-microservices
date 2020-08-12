package sqa.springopencartproductservice.Service.ServiceInt;

import sqa.springopencartproductservice.Entity.Product;

import java.util.Collection;

public interface ProductService {
    Collection<Product> findProductByName(String name);

    Product findProductByID(Integer ID);

    Collection<Product> listAllProducts();

    void addProduct(Product product);

    void saveProduct(Product product);

    void deleteProduct(Integer ID);

    void addToCart(Integer productID, Integer customerID);

    void addToWishList(Integer productID, Integer customerID);
}
