package lee.joohan.springmongoexample.config;

import java.nio.charset.Charset;
import java.time.Duration;
import java.util.Arrays;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.BufferingClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.DefaultUriBuilderFactory;

/**
 * Created by Joohan Lee on 2019/11/07
 */
@Configuration
public class RestTemplateConfig {
  @Bean
  public CloseableHttpClient httpClient() {
    return HttpClientBuilder.create()
        .setMaxConnTotal(20)
        .setMaxConnPerRoute(20)
        .build();
  }

  @Bean
  public RestTemplate restTemplateExampleOne(@Value("${spring.restTemplate.baseUrl}") String baseUrl, CloseableHttpClient client) {
    HttpComponentsClientHttpRequestFactory httpRequestFactory = new HttpComponentsClientHttpRequestFactory(client);

    httpRequestFactory.setConnectTimeout(5000);
    httpRequestFactory.setReadTimeout(20000);

    RestTemplate restTemplate = new RestTemplate(httpRequestFactory);

    restTemplate.setUriTemplateHandler(new DefaultUriBuilderFactory(baseUrl));
    restTemplate.setInterceptors(Arrays.asList(new RestTemplateRequestLogInterceptor()));

    return restTemplate;
  }


  @Bean
  public RestTemplate restTemplateExampleTwo(RestTemplateBuilder restTemplateBuilder) {
    return restTemplateBuilder
        .requestFactory(() -> new BufferingClientHttpRequestFactory(new SimpleClientHttpRequestFactory()))
        .setConnectTimeout(Duration.ofMillis(30000))
        .setReadTimeout(Duration.ofMillis(30000))
        .additionalMessageConverters(new StringHttpMessageConverter(Charset.forName("UTF-8")))
        .additionalInterceptors(new RestTemplateRequestLogInterceptor())
        .build();
  }

}
