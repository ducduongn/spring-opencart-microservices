package sqa.springopencartproductservice.model.RepoImpl;

import org.springframework.stereotype.Repository;
import sqa.springopencartproductservice.model.Entity.Order;
import sqa.springopencartproductservice.model.Repository.OrderRepository;

import java.util.Collection;

@Repository
public class OrderRepositoryImpl implements OrderRepository {
    @Override
    public Order findOrderByID(int ID) {
        return null;
    }

    @Override
    public void save(Order order) {

    }

    @Override
    public void deleteById(Integer Id) {

    }

    @Override
    public Collection<Order> listAllOrders() {
        return null;
    }
}
