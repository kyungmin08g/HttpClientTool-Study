package kyungmin.httpclienttoolstudy.rest_client.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
@RequiredArgsConstructor
public class RestClientService {
  private final RestClient.Builder restClient;
  private final ObjectMapper objectMapper;

  @Value("${open-api.key}")
  private String appKey;

  // Get
  public JsonNode getApiRequest(String schoolName) {
    String request = restClient.baseUrl("https://open.neis.go.kr/hub")
      .build()
      .get()
      .uri(uriBuilder -> uriBuilder.path("/schoolInfo")
        .queryParam("KEY", appKey)
        .queryParam("Type", "json")
        .queryParam("pIndex", 1)
        .queryParam("pSize", 2)
        .queryParam("SCHUL_NM", schoolName)
        .build()
      )
      .retrieve()
      .body(String.class);

    try {
      return objectMapper.readTree(request);
    } catch (Exception e) {
      e.printStackTrace();
    }

    return null;
  }
}
