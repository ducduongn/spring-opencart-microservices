package sqa.springopencartproductservice.model.RepoImpl;

import org.springframework.stereotype.Repository;
import sqa.springopencartproductservice.model.Entity.Order;
import sqa.springopencartproductservice.model.Repository.OrderRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.Collection;

@Repository
public class OrderRepositoryImpl implements OrderRepository {
    @PersistenceContext
    private EntityManager em;

    @Override
    public Order findOrderByID(int ID) {
        Query query = this.em.createQuery("SELECT o FROM Order o WHERE o.orderId = :id");
        query.setParameter("id", ID);
        return (Order) query.getSingleResult();
    }

    @Override
    public void save(Order order) {
        Query query = this.em.createNativeQuery("UPDATE `order` o " +
                "SET o.orderId=:oid, o.customerId=:cusid, o.orderDate=:od, o.requiredDate=:rd, o.shippedDate=:sd, o.status=:os " +
                "WHERE o.orderId=" + order.getOrderId());
        query.executeUpdate();
    }

    @Override
    public void deleteById(Integer Id) {

    }

    @Override
    public Collection<Order> listAllOrders() {
//        TypedQuery<Order> query = (TypedQuery<Order>) em.createQuery("SELECT o FROM Order o", Order.class);
//        return (Collection<Order>) query.getResultList();
        Query query = this.em.createNativeQuery("SELECT orderId, orderDate, requiredDate, shippedDate, status, customerId FROM `order` o");

//        System.out.println(query.getSingleResult().toString());
        //System.out.println(query.getResultList().toArray().length);

        return query.getResultList();
    }

}
