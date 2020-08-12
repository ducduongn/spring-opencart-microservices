package sqa.springopencart.customerservice.model.RepoImpl;

import org.springframework.stereotype.Repository;
import sqa.springopencart.customerservice.model.Entity.Customer;
import sqa.springopencart.customerservice.model.Repository.CustomerRepository;

import java.util.Collection;

@Repository
public class CustomerRepositoryImpl implements CustomerRepository {
    @Override
    public Customer findByAccountNameAndPassword(String accountName, String password) {
        return null;
    }

    @Override
    public Collection<Customer> findCustomerByName(String customerName) {
        return null;
    }

    @Override
    public Customer findCustomerByID(Integer ID) {
        return null;
    }

    @Override
    public Customer findCustomerAccount(String accountName) {
        return null;
    }

    @Override
    public Collection<Customer> findAllCustomer() {
        return null;
    }

    @Override
    public void addCustomer(Customer customer) {

    }

    @Override
    public void saveInfo(Customer customer) {

    }
}
