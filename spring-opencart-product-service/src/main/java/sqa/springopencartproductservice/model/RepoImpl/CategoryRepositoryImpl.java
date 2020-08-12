package sqa.springopencartproductservice.model.RepoImpl;

import org.springframework.stereotype.Repository;
import sqa.springopencartproductservice.model.Entity.Category;
import sqa.springopencartproductservice.model.Entity.Product;
import sqa.springopencartproductservice.model.Repository.CategoryRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collection;

@Repository
public class CategoryRepositoryImpl implements CategoryRepository {
    @PersistenceContext
    private EntityManager em;

    @Override
    public Collection<Product> findProductByCategory(int CategoryID) {
        return null;
    }

    @Override
    public Collection<Category> findCategoryByName(String categoryName) {
        return null;
    }

    @Override
    public Category findCategoryById(int categoryID) {
        return null;
    }

    @Override
    public void save(Category category) {

    }
}
