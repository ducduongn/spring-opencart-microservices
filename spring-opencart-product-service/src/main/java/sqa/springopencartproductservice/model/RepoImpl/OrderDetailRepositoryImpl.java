package sqa.springopencartproductservice.model.RepoImpl;

import org.springframework.stereotype.Repository;
import sqa.springopencartproductservice.model.Repository.OrderDetailRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class OrderDetailRepositoryImpl implements OrderDetailRepository {
    @PersistenceContext
    private EntityManager em;
}
