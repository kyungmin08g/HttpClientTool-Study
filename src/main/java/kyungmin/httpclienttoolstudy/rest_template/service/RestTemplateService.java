package kyungmin.httpclienttoolstudy.rest_template.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Service
@RequiredArgsConstructor
@Slf4j
public class RestTemplateService {
  private final RestTemplate restTemplate;
  private final ObjectMapper objectMapper;

  @Value("${open-api.key}")
  private String appKey;

  // Get
  public JsonNode getApiRequest(String schoolName) {
    URI uri = UriComponentsBuilder
      .fromUriString("https://open.neis.go.kr/hub")
      .path("/schoolInfo")
      .queryParam("KEY", appKey)
      .queryParam("Type", "json")
      .queryParam("pIndex", 1)
      .queryParam("pSize", 1)
      .queryParam("SCHUL_NM", schoolName)
      .encode()
      .build()
      .toUri();
    ResponseEntity<String> response = restTemplate.getForEntity(uri, String.class);

    try {
      return objectMapper.readTree(response.getBody());
    } catch (Exception e) {
      e.printStackTrace();
    }

    return null;
  }
}
