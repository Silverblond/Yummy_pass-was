package yuseteam.mealticketsystemwas.domain.order.dto;

import lombok.Getter;

import java.util.List;

@Getter
public class CreateOrderReq {
    private List<Item> items; // 프론트/쿠키에서 담아 보내는 장바구니

    @Getter
    public static class Item {
        private Long menuId;
        private int quantity;
    }
}