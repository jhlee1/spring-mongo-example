package lee.joohan.springmongoexample.interfaces.response;

import lee.joohan.springmongoexample.domain.Customer;
import lombok.Getter;

/**
 * Created by Joohan Lee on 2019/11/13
 */

@Getter
public class EditCustomerResponse {
  private String userId;
  private String firstName;
  private String lastName;
  private Integer age;

  public EditCustomerResponse(Customer customer) {
    firstName = customer.getFirstName();
    lastName = customer.getLastName();
    userId = customer.getUserId();
    age = customer.getAge();
  }
}
