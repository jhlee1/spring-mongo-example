package lee.joohan.springmongoexample.application;

import java.util.List;
import java.util.Optional;
import lee.joohan.springmongoexample.domain.Customer;
import lee.joohan.springmongoexample.domain.exception.CustomerNotFoundException;
import lee.joohan.springmongoexample.interfaces.request.CreateCustomerRequest;
import lee.joohan.springmongoexample.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Created by Joohan Lee on 2019-09-27
 */
@Service
@RequiredArgsConstructor
public class CustomerService {
  private final CustomerRepository customerRepository;

  public Customer createCustomer(CreateCustomerRequest createCustomerRequest) {
    Customer customer = createCustomerRequest.toCustomer();

    return customerRepository.save(customer);
  }

  public Customer getCustomers(String firstName) {
    return customerRepository.findByFirstName(firstName);
  }

  public List<Customer> getCustomers() {
    return customerRepository.findAll();
  }

  public void deleteCustomer(String userId) {
    Customer customer = Optional.ofNullable(customerRepository.findByUserId(userId))
        .orElseThrow(() -> new CustomerNotFoundException(userId));

    customerRepository.delete(customer);
  }

}
