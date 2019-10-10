package lee.joohan.springmongoexample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.telegram.telegrambots.ApiContextInitializer;

@SpringBootApplication
public class SpringMongoExampleApplication {
  public static void main(String[] args) {
    ApiContextInitializer.init();
    SpringApplication.run(SpringMongoExampleApplication.class, args);
  }
}
