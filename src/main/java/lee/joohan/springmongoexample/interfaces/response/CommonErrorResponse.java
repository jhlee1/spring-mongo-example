package lee.joohan.springmongoexample.interfaces.response;

import lombok.Builder;
import lombok.Getter;

/**
 * Created by Joohan Lee on 2019-09-27
 */

@Getter
@Builder
public class CommonErrorResponse  {
  private long errorCode;
  private String errorMessage;

}
