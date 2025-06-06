package kyungmin.httpclienttoolstudy.service;

import kyungmin.httpclienttoolstudy.controller.response.GetSchoolInfoResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class APIService {
  private final NeisClient neisClient;

  @Value(value = "${open-api.key}")
  private String appKey;

  public GetSchoolInfoResponse getApiRequest(String schoolName) {
    return neisClient.getSchoolInfo(appKey, "json", 1, 1, schoolName);
  }
}
