package kyungmin.httpclienttoolstudy.web_client.controller;

import kyungmin.httpclienttoolstudy.web_client.service.WebClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "web-client")
public class WebClientController {
  private final WebClientService service;

  @GetMapping(value = "/request")
  public ResponseEntity<Void> apiRequest(@RequestParam(value = "schoolName") String schoolName) {
    return ResponseEntity.ok().build();
  }
}
