package sqa.springopencart.customerservice.Service.ServiceInt;

import sqa.springopencart.customerservice.Entity.Cart;
import sqa.springopencartproductservice.Entity.Product;

import java.util.Collection;

public interface CartService {
    Collection<Cart> findCartByName(String name);

    Cart findCartByID(Integer ID);

    Double checkOutCart();

    Collection<Product> showProductByCart(Integer ID);

    void addProductToWishList(Integer productID, Integer customerID);

    void removeProductFromCart(Product product);

    Product findProductByID(Integer ID);

    void addToCart(Integer productID, Integer customerID);

    void initCart(Integer ID);

    void clear(Integer ID);
}
