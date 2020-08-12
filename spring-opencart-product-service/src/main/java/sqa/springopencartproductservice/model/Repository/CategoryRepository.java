package sqa.springopencartproductservice.model.Repository;

import sqa.springopencartproductservice.model.Entity.Category;
import sqa.springopencartproductservice.model.Entity.Product;

import java.util.Collection;

public interface CategoryRepository {
    Collection<Product> findProductByCategory(int CategoryID);

    Collection<Category> findCategoryByName(String categoryName);

    Category findCategoryById(int categoryID);

    void save(Category category);
}
