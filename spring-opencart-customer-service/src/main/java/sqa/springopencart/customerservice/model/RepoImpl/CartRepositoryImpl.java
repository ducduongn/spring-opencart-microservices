package sqa.springopencart.customerservice.model.RepoImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import sqa.springopencart.customerservice.model.Entity.Cart;
import sqa.springopencart.customerservice.model.Repository.CartRepository;
import sqa.springopencartproductservice.model.Entity.Product;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collection;

@Repository
public class CartRepositoryImpl implements CartRepository {
    @Autowired
    private EntityManager em;

    @Override
    @SuppressWarnings("unchecked")
    public Collection<Product> findAllProduct(Integer ID) {
//        Query query = this.em.createQuery("SELECT p FROM Product p");
        Query query = this.em.createNativeQuery("SELECT p.* FROM product p JOIN `cart-product` cp on p.productId = cp.productId JOIN cart c on cp.customerId = c.customerId WHERE c.customerId = :ID", Product.class);
        query.setParameter("ID", ID);
        return query.getResultList();
    }

    @Override
    public void addToWishList(Product product, Integer customerID) {
        Query query = this.em.createNativeQuery("INSERT INTO `wishlist-product`(customerId, productId) " +
                "VALUES (?, ?)");
        query.setParameter(1, customerID);
        query.setParameter(2, product.getProductID());
        query.executeUpdate();
    }

    @Override
    public void removeProductInCart(Product product) {
        Query query = this.em.createNativeQuery("DELETE FROM `cart-product` cp WHERE cp.productId = " + product.getProductId());
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

    @Override
    public Cart findCartByID(Integer ID) {
        TypedQuery<Cart> q = em.createQuery("SELECT c FROM Cart c WHERE c.customerId = :id", Cart.class);
        q.setParameter("id", ID);
        return q.getSingleResult();
    }

    @Override
    public Collection<Cart> findCartByName(String name) {
        TypedQuery<Cart> q = em.createQuery("SELECT c FROM Cart c WHERE c.customer.lastName = :name OR c.customer.firstName = :name", Cart.class);
        q.setParameter("name", name);
        return q.getResultList();
    }

    @Override
    public void save(Cart cart) {
        if (cart.getCustomerId() == null) this.em.persist(cart);
        else this.em.merge(cart);
    }

    @Override
    public Double checkOut() {
        Query query = this.em.createNativeQuery("SELECT SUM(c.quantity * p.priceunit) FROM cart c JOIN `cart-product` cp ON c.customerId = cp.customerId JOIN product p ON cp.productId = p.productId");
        return (Double) query.getSingleResult();
    }

    @Override
    public Product findProductById(Integer ID) {
        TypedQuery<Product> q = em.createQuery("SELECT b FROM Product b WHERE b.productId = :id", Product.class);
        q.setParameter("id", ID);
        return q.getSingleResult();
    }

    @Override
    public void initCart(Integer ID) {
        Query query = this.em.createNativeQuery("INSERT INTO cart (customerId, dateAdded, quantity) VALUES (?, ?, ?)");
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        query.setParameter(1, ID).setParameter(2, dtf.format(now)).setParameter(3, 1).executeUpdate();
    }

    @Override
    public void clear(Integer ID) {
        Query query = this.em.createNativeQuery("DELETE FROM `cart-product` WHERE customerId = " + ID);
        query.executeUpdate();
    }
}
