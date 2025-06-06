package kyungmin.httpclienttoolstudy.feign_client.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import kyungmin.httpclienttoolstudy.feign_client.controller.response.GetSchoolInfoResponse;
import kyungmin.httpclienttoolstudy.feign_client.service.APIService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api")
@Tag(name = "나이스 관련 API")
public class APIController {
  private final APIService apiService;

  @GetMapping(value = "/request")
  @Operation(summary = "학교 조회 API 호출")
  public ResponseEntity<GetSchoolInfoResponse> apiRequest(@RequestParam("schoolName") String schoolName) {
    return ResponseEntity.ok(apiService.getApiRequest(schoolName));
  }
}
