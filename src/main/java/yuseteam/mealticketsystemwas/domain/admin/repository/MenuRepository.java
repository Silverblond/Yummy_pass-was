package yuseteam.mealticketsystemwas.domain.admin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import yuseteam.mealticketsystemwas.entity.Menu;

public interface MenuRepository extends JpaRepository<Menu,Long> {
}
