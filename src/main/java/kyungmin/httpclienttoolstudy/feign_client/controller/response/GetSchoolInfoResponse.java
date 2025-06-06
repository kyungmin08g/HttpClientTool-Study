package kyungmin.httpclienttoolstudy.feign_client.controller.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "학교 정보 조회 응답 객체")
public class GetSchoolInfoResponse {
  private List<SchoolInfoRow> schoolInfo;
}
