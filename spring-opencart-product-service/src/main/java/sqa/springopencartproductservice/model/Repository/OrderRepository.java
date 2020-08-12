package sqa.springopencartproductservice.model.Repository;

import sqa.springopencartproductservice.model.Entity.Order;

import java.util.Collection;

public interface OrderRepository {
    Order findOrderByID(int ID);

    void save(Order order);

    void deleteById(Integer Id);

    Collection<Order> listAllOrders();
//    void add(Order order);
}
