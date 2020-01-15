package lee.joohan.springmongoexample.repository;

import java.util.List;
import lee.joohan.springmongoexample.domain.Customer;

/**
 * Created by Joohan Lee on 2020/01/14
 */
public interface CustomerRepositoryCustom {
  List<Customer> findByFilter(String firstName, String lastName);
}
