package lee.joohan.springmongoexample.resource;

import java.util.List;
import lee.joohan.springmongoexample.application.ZipCodeService;
import lee.joohan.springmongoexample.domain.ZipCode;
import lee.joohan.springmongoexample.domain.ZipCodeGroupedByState;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Joohan Lee on 2019-10-10
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("zipcodes")
public class ZipCodeResources {
  private final ZipCodeService zipCodeService;


  @GetMapping
  public ResponseEntity getZipCodes(@RequestParam(name = "limit", defaultValue = "20") int limit) {
    List<ZipCode> zipCodes = zipCodeService.getZipCodes(limit);

    return ResponseEntity.status(HttpStatus.OK).body(zipCodes);
  }
  @GetMapping("groupByStates")
  public ResponseEntity getGroupByStates() {
    List<ZipCodeGroupedByState> zipCodeGroupedByStates = zipCodeService.getZipCodeGroupedByState();

    return ResponseEntity.ok(zipCodeGroupedByStates);
  }

}
