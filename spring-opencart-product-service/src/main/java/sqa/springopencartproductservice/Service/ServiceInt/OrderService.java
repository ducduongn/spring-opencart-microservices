package sqa.springopencartproductservice.Service.ServiceInt;

import sqa.springopencartproductservice.Entity.Order;

import java.util.Collection;

public interface OrderService {
    Collection<Order> listAllOrder();
}
