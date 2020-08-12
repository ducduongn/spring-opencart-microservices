package sqa.springopencart.customerservice.Repository.RepositoryInt;

import sqa.springopencart.customerservice.Entity.Customer;

import java.util.Collection;

public interface CustomerRepository{
    Customer findByAccountNameAndPassword(String accountName, String password);
    Collection<Customer> findCustomerByName(String customerName);
    Customer findCustomerByID(Integer ID);
    Customer findCustomerAccount(String accountName);
    Collection<Customer> findAllCustomer();
    void addCustomer(Customer customer);
    void saveInfo(Customer customer);
}
