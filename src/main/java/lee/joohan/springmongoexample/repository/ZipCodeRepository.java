package lee.joohan.springmongoexample.repository;

import lee.joohan.springmongoexample.domain.ZipCode;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Joohan Lee on 2019-10-10
 */
@Repository
public interface ZipCodeRepository extends MongoRepository<ZipCode, String>, ZipCodeRepositoryCustom {
}
