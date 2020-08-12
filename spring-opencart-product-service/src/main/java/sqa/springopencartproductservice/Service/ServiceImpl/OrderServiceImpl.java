package sqa.springopencartproductservice.Service.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sqa.springopencartproductservice.Service.ServiceInt.OrderService;
import sqa.springopencartproductservice.Entity.Order;
import sqa.springopencartproductservice.Repository.RepositoryInt.OrderRepository;

import java.util.Collection;

@Service
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    @Transactional
    public Collection<Order> listAllOrder() {
        return orderRepository.listAllOrders();
    }
}
