package kyungmin.httpclienttoolstudy.rest_client.controller;

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

  @GetMapping(value = "/request")
  public ResponseEntity<Void> apiRequest(@RequestParam(value = "schoolName") String schoolName) {
    return ResponseEntity.ok().build();
  }
}
