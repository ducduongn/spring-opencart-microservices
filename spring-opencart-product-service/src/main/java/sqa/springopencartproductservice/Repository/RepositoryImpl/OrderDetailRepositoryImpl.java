package sqa.springopencartproductservice.Repository.RepositoryImpl;

import org.springframework.stereotype.Repository;
import sqa.springopencartproductservice.Repository.RepositoryInt.OrderDetailRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class OrderDetailRepositoryImpl implements OrderDetailRepository {
    @PersistenceContext
    private EntityManager em;
}
