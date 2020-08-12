package sqa.springopencart.customerservice.Repository.RepositoryInt;

import sqa.springopencart.customerservice.Entity.Cart;
import sqa.springopencartproductservice.Entity.Product;

import java.util.Collection;

public interface CartRepository{
    Collection<Product> findAllProduct(Integer ID);
    void removeProductInCart(Product product);
    void addProduct(Integer productID, Integer customerID);
    Cart findCartByID(Integer ID);
    Collection<Cart> findCartByName(String name);
    void addToWishList(Product product, Integer ID);
    void save(Cart cart);
    Double checkOut();
    Product findProductById(Integer ID);
    void initCart(Integer ID);
    void clear(Integer ID);
}
