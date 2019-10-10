package lee.joohan.springmongoexample.repository;

import static org.springframework.data.mongodb.core.aggregation.Aggregation.group;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.newAggregation;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.project;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.sort;

import java.util.List;
import lee.joohan.springmongoexample.domain.ZipCodeGroupedByState;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.GroupOperation;
import org.springframework.data.mongodb.core.aggregation.ProjectionOperation;

/**
 * Created by Joohan Lee on 2019-10-10
 */

@RequiredArgsConstructor
public class ZipCodeRepositoryImpl implements ZipCodeRepositoryCustom {
  private final MongoTemplate mongoTemplate;

  @Override
  public List<ZipCodeGroupedByState> groupByState() {
    GroupOperation groupByState = group("state")
        .addToSet("city").as("cities");

    ProjectionOperation projectionOperation = project()
        .andExpression("_id").as("state")
        .andExpression("cities").as("cities");

    Aggregation aggregation = newAggregation(groupByState, projectionOperation);

    System.out.println(mongoTemplate.aggregate(aggregation, "zips", ZipCodeGroupedByState.class).getRawResults());

    return mongoTemplate.aggregate(aggregation, "zips", ZipCodeGroupedByState.class).getMappedResults();


  }
}
