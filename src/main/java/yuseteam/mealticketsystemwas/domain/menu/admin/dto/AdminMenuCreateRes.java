package yuseteam.mealticketsystemwas.domain.menu.admin.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import yuseteam.mealticketsystemwas.domain.menu.common.entity.Menu;
import yuseteam.mealticketsystemwas.domain.menu.common.entity.MenuCategory;

@Getter
@Builder
@AllArgsConstructor
@Schema(description = "관리자 메뉴 등록 응답 DTO")
public class AdminMenuCreateRes {
    @Schema(description = "메뉴 ID", example = "1")
    private final Long id;

    @Schema(description = "메뉴 이름", example = "치킨마요덮밥")
    private final String name;

    @Schema(description = "메뉴 사진 URL", example = "https://s3.amazonaws.com/happinessql/menu1.jpg")
    private final String photoUrl;

    @Schema(description = "메뉴 가격", example = "8000")
    private final int price;

    @Schema(description = "총 수량", example = "50")
    private final int totalCount;

    @Schema(description = "누적 판매된 식권 수", example = "12")
    private final int soldTicket;

    @Schema(description = "카테고리", example = "KOREAN")
    private final MenuCategory category;

    @Schema(description = "노출 여부", example = "true")
    private final Boolean visible;


    public static AdminMenuCreateRes from(Menu menu) {
        return AdminMenuCreateRes.builder()
                .id(menu.getId())
                .name(menu.getName())
                .photoUrl(menu.getPhotoUrl())
                .price(menu.getPrice())
                .totalCount(menu.getTotalQuantity())
                .soldTicket(menu.getCumulativeSoldQuantity())
                .category(menu.getCategory())
                .visible(menu.getVisible())
                .build();
    }
}
