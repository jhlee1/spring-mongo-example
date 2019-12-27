package lee.joohan.springmongoexample.config;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.util.StreamUtils;

/**
 * Created by Joohan Lee on 2019/11/07
 */
@Slf4j
public class RestTemplateRequestLogInterceptor implements ClientHttpRequestInterceptor {

  @Override
  public ClientHttpResponse intercept(
      HttpRequest request,
      byte[] body,
      ClientHttpRequestExecution execution) throws IOException {

    StringBuilder requestLog = new StringBuilder()
        .append("[OCP Request] ")
        .append(request.getMethod())
        .append(" ")
        .append(request.getURI());

    if (body.length > 0) {
      requestLog
          .append(", Body: ")
          .append(new String(body, StandardCharsets.UTF_8));
    }

    log.info(requestLog.toString());

    ClientHttpResponse response = execution.execute(request, body);

    String responseLog = new StringBuilder()
        .append("[RESPONSE] ")
        .append("Status: ")
        .append(response.getStatusCode())
        .append(", Body : ")
        .append(StreamUtils.copyToString(response.getBody(), StandardCharsets.UTF_8))
        .toString();

    log.info(responseLog);

    return execution.execute(request, body);
  }
}

