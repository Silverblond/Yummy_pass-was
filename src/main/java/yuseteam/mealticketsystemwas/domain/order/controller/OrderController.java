package yuseteam.mealticketsystemwas.domain.order.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import yuseteam.mealticketsystemwas.domain.oauthjwt.dto.UserDTO;
import yuseteam.mealticketsystemwas.domain.order.dto.CreateOrderReq;
import yuseteam.mealticketsystemwas.domain.order.dto.OrderCreatedRes;
import yuseteam.mealticketsystemwas.domain.order.dto.OrderSummaryRes;
import yuseteam.mealticketsystemwas.domain.order.service.OrderService;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    /** 장바구니 바디로 보낸 항목 즉석 합계(저장 X) */
    @PostMapping("/summary")
    public ResponseEntity<OrderSummaryRes> summarize(@RequestBody CreateOrderReq req) {
        return ResponseEntity.ok(orderService.summarize(req.getItems()));
    }

    /** 결제(주문 확정) — 바디로 장바구니 항목 전달 */
    @PostMapping("/checkout")
    public ResponseEntity<OrderCreatedRes> checkout(
            @RequestBody CreateOrderReq req,
            @AuthenticationPrincipal UserDTO user) {
        return ResponseEntity.ok(orderService.checkout(user.getId(), req));
    }
}