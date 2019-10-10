package lee.joohan.springmongoexample.interfaces.response;

import java.util.List;
import java.util.stream.Collectors;
import lee.joohan.springmongoexample.domain.Customer;
import lombok.Getter;

/**
 * Created by Joohan Lee on 2019-09-27
 */
@Getter
public class GetCustomersResponse {
  private List<GetCustomerResponse> customers;

  public GetCustomersResponse(List<Customer> customers) {
    this.customers = customers.stream()
        .map(GetCustomerResponse::new)
        .collect(Collectors.toList());
  }
}
