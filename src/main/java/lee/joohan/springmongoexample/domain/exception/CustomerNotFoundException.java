package lee.joohan.springmongoexample.domain.exception;

/**
 * Created by Joohan Lee on 2019-09-27
 */
public class CustomerNotFoundException extends RuntimeException {
  public CustomerNotFoundException(String userId) {
    super(new StringBuilder("The user[")
        .append(userId)
        .append("] is not found.")
        .toString()
    );
  }
}
