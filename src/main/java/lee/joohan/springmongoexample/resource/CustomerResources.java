package lee.joohan.springmongoexample.resource;

import java.util.List;
import javax.validation.Valid;
import lee.joohan.springmongoexample.application.CustomerService;
import lee.joohan.springmongoexample.common.CustomHttpStatus;
import lee.joohan.springmongoexample.domain.Customer;
import lee.joohan.springmongoexample.domain.exception.CustomerNotFoundException;
import lee.joohan.springmongoexample.interfaces.request.CreateCustomerRequest;
import lee.joohan.springmongoexample.interfaces.response.CommonErrorResponse;
import lee.joohan.springmongoexample.interfaces.response.CreateCustomerResponse;
import lee.joohan.springmongoexample.interfaces.response.GetCustomersResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Joohan Lee on 2019-09-27
 */
@RestController
@RequestMapping("customers")
@RequiredArgsConstructor
public class CustomerResources {
  private final CustomerService customerService;

  @PostMapping
  public ResponseEntity createCustomer(@RequestBody @Valid CreateCustomerRequest createCustomerRequest) {
    Customer customer = customerService.createCustomer(createCustomerRequest);

    return ResponseEntity.ok(new CreateCustomerResponse(customer));
  }

  @GetMapping
  public ResponseEntity getCustomers() {
    List<Customer> customers = customerService.getCustomers();

    return ResponseEntity.ok(new GetCustomersResponse(customers));
  }

  @DeleteMapping("/{userId}")
  public ResponseEntity deleteCustomer(@PathVariable String userId) {
    try {
      customerService.deleteCustomer(userId);
    } catch (CustomerNotFoundException e) {
      CommonErrorResponse commonErrorResponse = CommonErrorResponse.builder()
          .errorCode(CustomHttpStatus.CUSTOMER_NOT_FOUND)
          .errorMessage(e.getMessage())
          .build();

      return ResponseEntity.status(HttpStatus.FORBIDDEN).body(commonErrorResponse);
    }

    return ResponseEntity.ok().build();
  }
}
