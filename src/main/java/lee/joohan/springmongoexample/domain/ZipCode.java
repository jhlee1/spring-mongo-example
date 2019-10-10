package lee.joohan.springmongoexample.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by Joohan Lee on 2019-10-10
 */
@NoArgsConstructor
//@AllArgsConstructor
@Document(collection = "zips")
@Getter
public class ZipCode {
  @Id
  private String _id;
  private String city;
  private double[] loc;
  private long pop;
  private String state;

}
