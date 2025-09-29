package yuseteam.mealticketsystemwas.domain.qr.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Schema(description = "QR 사용 요청 DTO")
public class QrUseRequest {
    @Schema(description = "QR uuid")
    private String uuid;

    public QrUseRequest() {}

    public QrUseRequest(String uuid) {
        this.uuid = uuid;
    }
}
