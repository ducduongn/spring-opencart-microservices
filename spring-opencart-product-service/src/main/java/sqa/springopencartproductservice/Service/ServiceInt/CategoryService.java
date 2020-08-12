package sqa.springopencartproductservice.Service.ServiceInt;

import sqa.springopencartproductservice.Entity.Category;
import sqa.springopencartproductservice.Entity.Product;

import java.util.Collection;

public interface CategoryService {
    Collection<Category> findCategoryByName(String name);

    Category findCategoryByID(Integer ID);

    Collection<Product> showProductByCategory(Integer categoryID);
}
