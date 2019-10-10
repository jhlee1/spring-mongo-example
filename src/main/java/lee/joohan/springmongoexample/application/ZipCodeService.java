package lee.joohan.springmongoexample.application;

import java.util.List;
import lee.joohan.springmongoexample.domain.ZipCode;
import lee.joohan.springmongoexample.domain.ZipCodeGroupedByState;
import lee.joohan.springmongoexample.repository.ZipCodeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

/**
 * Created by Joohan Lee on 2019-10-10
 */
@Service
@RequiredArgsConstructor
public class ZipCodeService {
  private final ZipCodeRepository zipCodeRepository;

  public List<ZipCodeGroupedByState> getZipCodeGroupedByState() {
    return zipCodeRepository.groupByState();
  }

  public List<ZipCode> getZipCodes(int limit) {
    return zipCodeRepository.findAll(PageRequest.of(0, limit)).getContent();
  }

}
