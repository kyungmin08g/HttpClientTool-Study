package kyungmin.httpclienttoolstudy.rest_template.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/rest-template")
@Tag(name = "RestTemplate 관련 API")
public class RestTemplateController {

  @GetMapping(value = "/request")
  public ResponseEntity<Void> apiRequest() {
    return ResponseEntity.ok().build();
  }
}
