package sqa.springopencartproductservice.Repository.RepositoryInt;

import sqa.springopencartproductservice.Entity.Category;
import sqa.springopencartproductservice.Entity.Product;

import java.util.Collection;

public interface CategoryRepository {
    Collection<Product> findProductByCategory(int CategoryID);

    Collection<Category> findCategoryByName(String categoryName);

    Category findCategoryById(int categoryID);

    void save(Category category);
}
