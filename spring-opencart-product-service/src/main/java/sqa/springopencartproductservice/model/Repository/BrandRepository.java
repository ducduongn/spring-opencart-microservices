package sqa.springopencartproductservice.model.Repository;

import sqa.springopencartproductservice.model.Entity.Brand;
import sqa.springopencartproductservice.model.Entity.Product;

import java.util.Collection;

public interface BrandRepository {
    Collection<Brand> findBrandByName(String name);

    Brand findBrandByID(int ID);

    Collection<Product> removeProductFromBrand(int productID);

    Collection<Product> addProductToBrand(Product product);

    Collection<Product> showProductInBrand(Integer ID);

    Collection<Brand> showAll();
}
