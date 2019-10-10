package lee.joohan.springmongoexample.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;

/**
 * Created by Joohan Lee on 2019-10-10
 */
@NoArgsConstructor
@ToString
@Getter
public class ZipCodeGroupedByState {
  private String state;
  private List<String> cities;
}
