package yuseteam.mealticketsystemwas.domain.menu.dto;

import lombok.*;

import java.time.LocalDateTime;
import java.util.Map;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MenuSalesDiffRes {
    private Map<Long, Integer> salesDiff;
    private LocalDateTime lastRecordedAt;
    private LocalDateTime previousRecordedAt;


}
