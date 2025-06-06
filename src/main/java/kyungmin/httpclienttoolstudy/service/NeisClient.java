package kyungmin.httpclienttoolstudy.service;

import kyungmin.httpclienttoolstudy.config.FeignClientConfig;
import kyungmin.httpclienttoolstudy.controller.response.GetSchoolInfoResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "neis-api", url = "https://open.neis.go.kr/hub", configuration = FeignClientConfig.class)
public interface NeisClient {

  @GetMapping(value = "/schoolInfo")
  GetSchoolInfoResponse getSchoolInfo(
    @RequestParam(value = "KEY") String key,
    @RequestParam(value = "Type") String type,
    @RequestParam(value = "pIndex") int pIndex,
    @RequestParam(value = "pSize") int pSize,
    @RequestParam(value = "SCHUL_NM") String schoolName
  );
}
