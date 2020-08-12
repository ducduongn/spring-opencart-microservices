package sqa.springopencart.customerservice.Service.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sqa.springopencart.customerservice.Service.ServiceInt.WishListService;
import sqa.springopencart.customerservice.Entity.WishList;
import sqa.springopencart.customerservice.Repository.RepositoryInt.WishListRepository;
import sqa.springopencartproductservice.Entity.Product;

import java.util.Collection;

@Service
public class WishListServiceImpl implements WishListService {
    private final WishListRepository wishListRepository;

    @Autowired
    public WishListServiceImpl(WishListRepository wishListRepository) {
        this.wishListRepository = wishListRepository;
    }

    @Override
    @Transactional
    public Collection<Product> showProductByWishList(Integer ID) {
        return wishListRepository.findAllProductInWishList(ID);
    }

    @Override
    @Transactional
    public void addProductToCart(Integer productId, Integer customerID) {
        wishListRepository.addToCart(productId, customerID);
    }

    @Override
    @Transactional
    public WishList findWishListByID(Integer ID) {
        return wishListRepository.findWishListByID(ID);
    }

    @Override
    @Transactional
    public void removeProductFromWishList(Product product) {
        wishListRepository.removeProductInWishList(product);
    }

    //null
    @Override
    @Transactional
    public Product findProductByID(Integer ID) {
        return wishListRepository.findProductByID(ID);
    }

    @Override
    @Transactional
    public void addToWishList(Integer productID, Integer customerID) {
        wishListRepository.addProduct(productID, customerID);
    }

    @Override
    @Transactional
    public void initWishlist(Integer ID) {
        wishListRepository.init(ID);
    }
}
