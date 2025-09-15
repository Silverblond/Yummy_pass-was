package yuseteam.mealticketsystemwas.domain.restaurant.dto;

import lombok.Getter;
import yuseteam.mealticketsystemwas.domain.restaurant.entity.Restaurant;

@Getter
public class RestaurantResponseDto {

    private final Long id;
    private final String name;

    public RestaurantResponseDto(Restaurant restaurant) {
        this.id = restaurant.getId();
        this.name = restaurant.getName();
    }
}
