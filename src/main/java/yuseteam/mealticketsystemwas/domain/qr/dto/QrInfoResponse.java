package yuseteam.mealticketsystemwas.domain.qr.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Schema(description = "QR 정보 응답 DTO")
public class QrInfoResponse {
    @Schema(description = "QR uuid")
    public String uuid;
    @Schema(description = "QR 이미지 URL")
    public String imageUrl;
    @Schema(description = "QR 사용 여부")
    public boolean used;

    public QrInfoResponse(String uuid, String imageUrl, boolean used) {
        this.uuid = uuid;
        this.imageUrl = imageUrl;
        this.used = used;
    }
}

