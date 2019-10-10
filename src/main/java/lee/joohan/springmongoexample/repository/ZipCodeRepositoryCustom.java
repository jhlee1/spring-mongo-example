package lee.joohan.springmongoexample.repository;

import java.util.List;
import lee.joohan.springmongoexample.domain.ZipCodeGroupedByState;

/**
 * Created by Joohan Lee on 2019-10-10
 */
public interface ZipCodeRepositoryCustom {
    List<ZipCodeGroupedByState> groupByState();
}
