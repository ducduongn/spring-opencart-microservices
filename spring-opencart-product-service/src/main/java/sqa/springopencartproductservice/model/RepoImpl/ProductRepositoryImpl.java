package sqa.springopencartproductservice.model.RepoImpl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import sqa.springopencartproductservice.model.Entity.Product;
import sqa.springopencartproductservice.model.Repository.ProductRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.Collection;

@Repository
public class ProductRepositoryImpl implements ProductRepository {
    @PersistenceContext
    private EntityManager em;

    //oke
    @Override
    public Collection<Product> findAllProduct() {
        TypedQuery<Product> q = em.createQuery("SELECT b FROM Product b ORDER BY b.productId", Product.class);
        return (Collection<Product>) q.getResultList();
    }

    //oke
    @Override
    public Collection<Product> findByName(String name) {
        TypedQuery<Product> q = em.createQuery("SELECT b FROM Product b WHERE b.name LIKE '%" + name + "%'", Product.class);
//        q.setParameter("name", name);
        return (Collection<Product>) q.getResultList();
    }


    //oke
    @Override
    public Product findById(int ID) {
        TypedQuery<Product> q = em.createQuery("SELECT b FROM Product b WHERE b.productId = :id", Product.class);
        q.setParameter("id", ID);
        return q.getSingleResult();
        //return em.find(Product.class, ID);
    }

    //oke
    @Override
    public void add(Product b) {
        Query query = this.em.createNativeQuery("INSERT INTO product " +
                "(productId, brandId, description, productName, quantity, dateAdded, dateModified, priceunit) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
        query.setParameter(1, b.getProductId());
        query.setParameter(2, b.getBrand().getBrandId());
        query.setParameter(3, b.getDescription());
        query.setParameter(4, b.getName());
        query.setParameter(5, b.getQuantity());
        query.setParameter(6, b.getDateAdded());
        query.setParameter(7, b.getDateModified());
        query.setParameter(8, b.getPrice());
        query.executeUpdate();
    }

    @Override
    public void save(Product b) {
        Query query = this.em.createNativeQuery("UPDATE product p " +
                "SET " +
                "p.brandId=:bid, " +
                "p.description=:des, " +
                "p.productName=:name, " +
                "p.quantity=:qtt, " +
                "p.dateAdded=:da, " +
                "p.dateModified=:dm, " +
                "p.priceunit=:pr " +
                "WHERE p.productId = " + b.getProductId());
        //query.setParameter("id", b.getProductId());
        query.setParameter("bid", b.getBrand().getBrandId());
        query.setParameter("des", b.getDescription());
        query.setParameter("name", b.getName());
        query.setParameter("qtt", b.getQuantity());
        query.setParameter("da", b.getDateAdded());
        query.setParameter("dm", b.getDateModified());
        query.setParameter("pr", b.getPrice());
        query.executeUpdate();
    }

    //oke
    @Override
    @Transactional
    public void deleteById(Integer ID) {
        Query query = em.createNativeQuery("DELETE FROM product WHERE " +
                "productId = " + ID);
        Query query1 = this.em.createNativeQuery("ALTER TABLE product AUTO_INCREMENT = " + ID);
        query.executeUpdate();
        query1.executeUpdate();
    }

    @Override
    public void addToCart(int productID, int customerID) {
        Query query = this.em.createNativeQuery("INSERT INTO `cart-product`(customerID, productID) VALUES(:customerID, :productID)");
        query.setParameter("customerID", customerID).setParameter("productID", productID).executeUpdate();
    }

    @Override
    public void addToWishList(int productID, int customerID) {
        Query query = this.em.createNativeQuery("INSERT INTO `wishlist-product`(customerId, productId) VALUES (?, ?)");
        query.setParameter(1, customerID).setParameter(2, productID).executeUpdate();
    }
}
