package yuseteam.mealticketsystemwas.domain.qr.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Schema(description = "QR 사용 요청 DTO")
public class QrUseReq {
    @Schema(description = "QR uuid")
    private String uuid;

    public QrUseReq() {}

    public QrUseReq(String uuid) {
        this.uuid = uuid;
    }
}
