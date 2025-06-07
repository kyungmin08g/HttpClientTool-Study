package kyungmin.httpclienttoolstudy.rest_template.controller;

import com.fasterxml.jackson.databind.JsonNode;
import io.swagger.v3.oas.annotations.tags.Tag;
import kyungmin.httpclienttoolstudy.rest_template.service.RestTemplateService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/rest-template")
@Tag(name = "RestTemplate 관련 API")
public class RestTemplateController {
  private final RestTemplateService service;

  @GetMapping(value = "/request")
  public ResponseEntity<JsonNode> apiRequest(@RequestParam(value = "schoolName") String schoolName) {
    return ResponseEntity.ok(service.getApiRequest(schoolName));
  }
}
