package kyungmin.httpclienttoolstudy.rest_client.controller;

import com.fasterxml.jackson.databind.JsonNode;
import kyungmin.httpclienttoolstudy.rest_client.service.RestClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/rest-client")
public class RestClientController {
  private final RestClientService service;

  @GetMapping(value = "/request")
  public ResponseEntity<JsonNode> apiRequest(@RequestParam(value = "schoolName") String schoolName) throws Exception {
    Thread.sleep(8000);
    return ResponseEntity.ok(service.getApiRequest(schoolName));
  }
}
