package sqa.springopencartproductservice.model.RepoImpl;

import org.springframework.stereotype.Repository;
import sqa.springopencartproductservice.model.Entity.Brand;
import sqa.springopencartproductservice.model.Entity.Product;
import sqa.springopencartproductservice.model.Repository.BrandRepository;

import java.util.Collection;

@Repository
public class BrandRepositoryImpl implements BrandRepository {
    @Override
    public Collection<Brand> findBrandByName(String name) {
        return null;
    }

    @Override
    public Brand findBrandByID(int ID) {
        return null;
    }

    @Override
    public Collection<Product> removeProductFromBrand(int productID) {
        return null;
    }

    @Override
    public Collection<Product> addProductToBrand(Product product) {
        return null;
    }

    @Override
    public Collection<Product> showProductInBrand(Integer ID) {
        return null;
    }

    @Override
    public Collection<Brand> showAll() {
        return null;
    }
}
