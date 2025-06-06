package kyungmin.httpclienttoolstudy.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api")
public class APIController {

  @GetMapping(value = "/request")
  public ResponseEntity<Void> apiRequest() {
    return ResponseEntity.ok().build();
  }
}
