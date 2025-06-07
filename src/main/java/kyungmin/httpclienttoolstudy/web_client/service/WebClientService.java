package kyungmin.httpclienttoolstudy.web_client.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class WebClientService {
  private final WebClient.Builder webClient;
  private final ObjectMapper objectMapper;

  @Value("${open-api.key}")
  private String appKey;

  // Get
  public JsonNode getApiRequest(String schoolName) {
    Mono<String> request = webClient.baseUrl("https://open.neis.go.kr/hub")
      .build()
      .get()
      .uri(uriBuilder -> uriBuilder.path("/schoolInfo")
        .queryParam("KEY", appKey)
        .queryParam("Type", "json")
        .queryParam("pIndex", 1)
        .queryParam("pSize", 1)
        .queryParam("SCHUL_NM", schoolName)
        .build()
      )
      .retrieve()
      .bodyToMono(String.class);

    try {
      return objectMapper.readTree(request.block());
    } catch (Exception e) {
      e.printStackTrace();
    }

    return null;
  }
}
