package sqa.springopencartproductservice.Service.ServiceInt;

import sqa.springopencartproductservice.Entity.Brand;
import sqa.springopencartproductservice.Entity.Product;

import java.util.Collection;

public interface BrandService {
    Collection<Brand> findBrandByName(String name);

    Brand findBrandByID(Integer ID);

    Collection<Product> showProductByBrand(Integer ID);

    Collection<Product> removeProductFromBrand(Product product);

    Collection<Brand> showAllBrand();
}
