package kyungmin.httpclienttoolstudy.controller.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "학교 정보 응답 Dto")
public class SchoolInfoDto {

  @JsonProperty(value = "SD_SCHUL_CODE")
  private String schoolCode;

  @JsonProperty(value = "HS_SC_NM")
  private String schoolName;

  @JsonProperty(value = "HMPG_ADRES")
  private String schoolSite;
}
