package sqa.springopencartproductservice.Service.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sqa.springopencartproductservice.Service.ServiceInt.ProductService;
import sqa.springopencartproductservice.Entity.Product;
import sqa.springopencartproductservice.Repository.RepositoryInt.ProductRepository;

import java.util.Collection;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    @Transactional
    public Collection<Product> findProductByName(String name) {
        return productRepository.findByName(name);
    }

    @Override
    @Transactional
    public Product findProductByID(Integer ID) {
        return productRepository.findById(ID);//.orElse(null);
    }

    @Override
    @Transactional
    public Collection<Product> listAllProducts() {
        return productRepository.findAllProduct();
    }

    @Override
    @Transactional
    public void addProduct(Product product) {
        productRepository.add(product);
    }

    @Override
    @Transactional
    public void saveProduct(Product product) {
        productRepository.save(product);
    }

    @Override
    @Transactional
    public void deleteProduct(Integer ID) {
        productRepository.deleteById(ID);
    }

    @Override
    @Transactional
    public void addToCart(Integer productID, Integer customerID) {
        productRepository.addToCart(productID, customerID);
    }

    @Override
    @Transactional
    public void addToWishList(Integer productID, Integer customerID) {
        productRepository.addToWishList(productID, customerID);
    }
}
