package yuseteam.mealticketsystemwas.domain.restaurant.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import yuseteam.mealticketsystemwas.domain.restaurant.dto.RestaurantResponseDto;
import yuseteam.mealticketsystemwas.domain.restaurant.service.RestaurantService;

import java.util.List;

@RestController
@RequestMapping("api/restaurants")
@RequiredArgsConstructor
public class RestuarantController {

    private final RestaurantService restaurantService;

    @GetMapping
    public ResponseEntity<List<RestaurantResponseDto>> getRestaurants() {
        List<RestaurantResponseDto> restaurants = restaurantService.getAllRestaurants();
        return ResponseEntity.ok(restaurants);
    }
}
