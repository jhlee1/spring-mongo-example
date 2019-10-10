package lee.joohan.springmongoexample.domain;

import java.util.UUID;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by Joohan Lee on 2019-09-27
 */
@Getter
@ToString
@NoArgsConstructor
@Document(collection = "customers")
public class Customer {
  @Id
  private String id;
  private String firstName;
  private String lastName;
  private String userId;
  private int age;

  @Builder
  public Customer(String firstName, String lastName, int age) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.userId = UUID.randomUUID().toString();
    this.age = age;
  }
}
