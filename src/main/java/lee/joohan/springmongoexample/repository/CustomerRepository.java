package lee.joohan.springmongoexample.repository;

import java.util.List;
import lee.joohan.springmongoexample.domain.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Joohan Lee on 2019-09-27
 */
@Repository
public interface CustomerRepository extends MongoRepository<Customer, String>, CustomerRepositoryCustom {
  Customer findFirstByFirstName(String firstName);
  List<Customer> findByFirstNameStartingWith(String firstName);
  Customer findByUserId(String userId);
}
