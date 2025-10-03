package yuseteam.mealticketsystemwas.domain.menu.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import yuseteam.mealticketsystemwas.domain.menu.dto.MenuSalesDiffRes;
import yuseteam.mealticketsystemwas.domain.menu.entity.MenuSalesSnapshot;
import yuseteam.mealticketsystemwas.domain.menu.repository.MenuSalesSnapshotrepository;
import yuseteam.mealticketsystemwas.domain.menu.service.MenuSalesSnapshotService;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/menus/sales-snapshots")
@RequiredArgsConstructor
@Slf4j
public class MenuSalesSnapshotController {

    private final MenuSalesSnapshotService menuSalesSnapshotService;
    private final MenuSalesSnapshotrepository menuSalesSnapshotrepository;

    @GetMapping("/sales-diff")
    public ResponseEntity<MenuSalesDiffRes> getSalesDiff() {
        List<MenuSalesSnapshot> snapshots = menuSalesSnapshotrepository.findAll();

        //데이터베이스에 없는 경우
        if(snapshots.isEmpty()) {
            log.warn("저장된 스냅샷 데이터가 없습니다. 스케줄러가 아직 실행되지 않았을 수 있습니다.");
            return ResponseEntity.ok(MenuSalesDiffRes.builder()
                    .salesDiff(new HashMap<>())
                    .lastRecordedAt(null)
                    .previousRecordedAt(null)
                    .build());
        }

        Map<Long, Integer> salesDiffMap = new HashMap<>();
        LocalDateTime lastestTime = null;
        LocalDateTime previousTime = null;

        for (MenuSalesSnapshot snapshot : snapshots) {
            Long menuId = snapshot.getMenu().getId();
            int diff = snapshot.getSalesDiff();
            salesDiffMap.put(menuId, diff);

            if (lastestTime == null) {
                lastestTime = snapshot.getCurrentRecordedAt();
                previousTime = snapshot.getPreviousRecordedAt();
            }
        }

        MenuSalesDiffRes res = MenuSalesDiffRes.builder()
                .salesDiff(salesDiffMap)
                .lastRecordedAt(lastestTime)
                .previousRecordedAt(previousTime)
                .build();

        return ResponseEntity.ok(res);
    }
}
