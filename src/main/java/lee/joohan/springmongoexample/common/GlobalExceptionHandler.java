package lee.joohan.springmongoexample.common;

import lee.joohan.springmongoexample.domain.exception.CustomerNotFoundException;
import lee.joohan.springmongoexample.interfaces.response.CommonErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Created by Joohan Lee on 2019-10-11
 */

//@ControllerAdvice(basePackageClasses = CustomerResources.class)
@ControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(CustomerNotFoundException.class)
  protected ResponseEntity<CommonErrorResponse> handleCustomerNotFoundException(CustomerNotFoundException e) {
    CommonErrorResponse commonErrorResponse = CommonErrorResponse.builder()
        .errorCode(CustomHttpStatus.CUSTOMER_NOT_FOUND)
        .errorMessage(e.getMessage())
        .build();

    return ResponseEntity.status(HttpStatus.FORBIDDEN).body(commonErrorResponse);
  }
}
