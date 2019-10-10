package lee.joohan.springmongoexample.repository;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Joohan Lee on 2019-10-10
 */
@SpringBootTest
@RunWith(SpringRunner.class)
@ActiveProfiles("local")
@Transactional
public class CustomerRepositoryTest {
  @Autowired
  CustomerRepository customerRepository;

  @Test
  public void findByFirstName() {
    System.out.println(customerRepository.findByFirstName("John"));

  }
}