package lee.joohan.springmongoexample.repository;

import static org.junit.Assert.*;

import telegram.ExampleBot;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Joohan Lee on 2019-10-10
 */
@SpringBootTest
@Transactional
@ActiveProfiles("prod")
@RunWith(SpringRunner.class)
public class ZipCodeRepositoryTest {

  @Autowired
  ExampleBot exampleBot;
  @Autowired
  ZipCodeRepository zipCodeRepository;

  @Test
  public void groupByState() {
    System.out.println("ZipCode Repository: " + zipCodeRepository);
//    System.out.println(zipCodeRepository.groupByState());
  }
}