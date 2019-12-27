package lee.joohan.springmongoexample.interfaces.request;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lee.joohan.springmongoexample.domain.Customer;
import lombok.Getter;
import lombok.NonNull;

/**
 * Created by Joohan Lee on 2019/11/13
 */

@Getter
@Valid
public class EditCustomerRequest {
  private String firstName;
  private String lastName;
  @NonNull
  private Integer age;
}
