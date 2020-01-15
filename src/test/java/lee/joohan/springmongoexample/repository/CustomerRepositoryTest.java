package lee.joohan.springmongoexample.repository;

import lee.joohan.springmongoexample.domain.Customer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by Joohan Lee on 2019-10-10
 */
@SpringBootTest
@RunWith(SpringRunner.class)
@ActiveProfiles("prod")
public class CustomerRepositoryTest {
  @Autowired
  CustomerRepository customerRepository;

  @Test
  public void save() {
    Customer customer = Customer.builder()
        .age(10)
        .firstName("Tester")
        .lastName("One")
        .build();

    System.out.println(customerRepository.save(customer));
  }

  @Test
  public void findByFirstName() {
    System.out.println(customerRepository.findFirstByFirstName("Tester"));
  }

  @Test
  public void findByFirstNameStartingWith() {
    System.out.println(customerRepository.findByFirstNameStartingWith("Te"));
  }

  @Test
  public void findByUserId() {
    System.out.println(customerRepository.findByUserId("8814a166-1007-4941-8628-75a445978f20"));
  }
}