package lee.joohan.springmongoexample;

import co.elastic.apm.attach.ElasticApmAttacher;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringMongoExampleApplication {
  public static void main(String[] args) {
    ElasticApmAttacher.attach();
    SpringApplication.run(SpringMongoExampleApplication.class, args);
  }
}
