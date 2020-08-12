package sqa.springopencart.customerservice.Repository.RepositoryImpl;

import org.springframework.stereotype.Repository;
import sqa.springopencart.customerservice.Entity.WishList;
import sqa.springopencart.customerservice.Repository.RepositoryInt.WishListRepository;
import sqa.springopencartproductservice.Entity.Product;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.Collection;

@Repository
public class WishListRepositoryImpl implements WishListRepository {
    @PersistenceContext
    private EntityManager em;

    @Override
    public Collection<Product> findAllProductInWishList(Integer ID) {
        Query query = this.em.createNativeQuery("SELECT p.* FROM product p JOIN `wishlist-product` wp on p.productId = wp.productId JOIN wishlist w on wp.customerId = w.customerId WHERE w.customerId = :ID", Product.class);
        query.setParameter("ID", ID);
        return query.getResultList();
    }

    @Override
    @SuppressWarnings("unchecked")
    public void addToCart(Integer productID, Integer customerID) {
        Query query = this.em.createNativeQuery("INSERT INTO `cart-product`(customerID, productID) VALUES(:customerID, :productID)");
        query.setParameter("customerID", customerID).setParameter("productID", productID).executeUpdate();
    }

    @Override
    public void removeProductInWishList(Product product) {
        Query query = this.em.createNativeQuery("DELETE FROM `wishlist-product` wp WHERE wp.productID = " + product.getProductId());
        query.executeUpdate();
    }

    @Override
    @SuppressWarnings("unchecked")
    public void addProduct(Integer productID, Integer customerID) {
        Query query = this.em.createNativeQuery("INSERT INTO `wishlist-product`(customerId, productId) " +
                "VALUES (?, ?)");
        query.setParameter(1, customerID);
        query.setParameter(2, productID);
        query.executeUpdate();
    }

    //not
    @Override
    public Product findProductByID(Integer ID) {
        TypedQuery<Product> q = em.createQuery("SELECT b FROM Product b WHERE b.productId = :id", Product.class);
        q.setParameter("id", ID);
        return q.getSingleResult();
    }

    @Override
    public void init(Integer ID) {
        Query query = this.em.createNativeQuery("INSERT INTO wishlist (customerId, status) VALUES (?, ?)");
        query.setParameter(1, ID).setParameter(2, "Favourite").executeUpdate();
    }

    @Override
    public void save(WishList wishList) {
        if (wishList.getCustomerId() == null) this.em.merge(wishList);
        else this.em.persist(wishList);
    }

    @Override
    @SuppressWarnings("unchecked")
    public WishList findWishListByID(Integer ID) {
        Query query = this.em.createQuery("SELECT w FROM WishList w WHERE w.customerId=:ID");
        query.setParameter("ID", ID);
        return (WishList) query.getSingleResult();
    }

}
