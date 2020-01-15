package lee.joohan.springmongoexample.repository;

import java.util.List;
import lee.joohan.springmongoexample.domain.Customer;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;

/**
 * Created by Joohan Lee on 2020/01/14
 */


@RequiredArgsConstructor
public class CustomerRepositoryImpl implements CustomerRepositoryCustom {
  private final MongoTemplate mongoTemplate;

  @Override
  public List<Customer> findByFilter(String firstName, String lastName) {
    return null;
  }
}
