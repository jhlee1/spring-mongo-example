package lee.joohan.springmongoexample.interfaces.response;

import lee.joohan.springmongoexample.domain.Customer;
import lombok.Getter;

/**
 * Created by Joohan Lee on 2019-09-27
 */
@Getter
public class CreateCustomerResponse {
  private String userId;
  private String firstName;
  private String lastName;

  public CreateCustomerResponse(Customer customer) {
    firstName = customer.getFirstName();
    lastName = customer.getLastName();
    userId = customer.getUserId();
  }
}
