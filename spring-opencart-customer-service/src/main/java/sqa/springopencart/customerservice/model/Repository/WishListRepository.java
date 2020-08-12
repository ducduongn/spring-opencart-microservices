package sqa.springopencart.customerservice.model.Repository;

import sqa.springopencart.customerservice.model.Entity.WishList;
import sqa.springopencartproductservice.model.Entity.Product;

import java.util.Collection;

public interface WishListRepository {
    Collection<Product> findAllProductInWishList(Integer ID);

    void addToCart(Integer productId, Integer customerID);

    void removeProductInWishList(Product product);

    void save(WishList wishList);

    WishList findWishListByID(Integer ID);

    void addProduct(Integer productID, Integer customerID);

    Product findProductByID(Integer ID);

    void init(Integer ID);
}
