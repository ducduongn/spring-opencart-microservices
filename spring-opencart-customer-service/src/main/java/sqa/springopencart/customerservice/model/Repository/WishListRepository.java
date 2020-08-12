package sqa.springopencart.customerservice.model.Repository;

import sqa.springopencart.customerservice.model.Entity.Customer;

import java.util.Collection;

public interface WishListRepository {
    Customer findByAccountNameAndPassword(String accountName, String password);

    Collection<Customer> findCustomerByName(String customerName);

    Customer findCustomerByID(Integer ID);

    Customer findCustomerAccount(String accountName);

    Collection<Customer> findAllCustomer();

    void addCustomer(Customer customer);

    void saveInfo(Customer customer);
}
