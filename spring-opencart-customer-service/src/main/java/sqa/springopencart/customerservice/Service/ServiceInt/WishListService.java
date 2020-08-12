package sqa.springopencart.customerservice.Service.ServiceInt;

import sqa.springopencart.customerservice.Entity.WishList;
import sqa.springopencartproductservice.Entity.Product;

import java.util.Collection;

public interface WishListService {
    Collection<Product> showProductByWishList(Integer ID);

    void addProductToCart(Integer productID, Integer customerID);

    WishList findWishListByID(Integer ID);

    void removeProductFromWishList(Product product);

    Product findProductByID(Integer ID);

    void addToWishList(Integer productID, Integer customerID);

    void initWishlist(Integer ID);
}
