package kyungmin.httpclienttoolstudy.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api")
@Tag(name = "나이스 관련 API")
public class APIController {

  @GetMapping(value = "/request")
  @Operation(summary = "학교 조회 API 호출")
  public ResponseEntity<Void> apiRequest() {
    return ResponseEntity.ok().build();
  }
}
