package yuseteam.mealticketsystemwas.domain.order.dto;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class OrderCreatedRes {
    private Long orderId;
    private int totalQuantity;
    private int totalAmount;

    private List<CreatedItem> items;
    private List<IssuedTicket> tickets;

    @Getter @Builder
    public static class CreatedItem {
        private Long menuId;
        private String menuName;
        private String restaurantName;
        private int unitPrice;
        private int quantity;
        private int lineTotal;
    }

    @Getter @Builder
    public static class IssuedTicket {
        private Long ticketId;
        private String qrUuid;
    }
}