package lee.joohan.springmongoexample.interfaces.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lee.joohan.springmongoexample.domain.Customer;
import lombok.Getter;

/**
 * Created by Joohan Lee on 2019-09-27
 */
@Getter
public class CreateCustomerRequest {
  @NotBlank
  private String firstName;
  @NotBlank
  private String lastName;

  @NotNull
  private Integer age;

  public Customer toCustomer() {
    return Customer.builder()
        .firstName(firstName)
        .lastName(lastName)
        .age(age)
        .build();
  }
}
