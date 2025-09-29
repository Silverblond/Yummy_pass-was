package yuseteam.mealticketsystemwas.domain.qr.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Schema(description = "QR 생성 응답 DTO")
public class QrCreateResponse {
    @Schema(description = "QR uuid")
    private final String uuid;
    @Schema(description = "QR 이미지 URL")
    private final String imageUrl;

    public QrCreateResponse(String uuid, String imageUrl) {
        this.uuid = uuid;
        this.imageUrl = imageUrl;
    }
}
