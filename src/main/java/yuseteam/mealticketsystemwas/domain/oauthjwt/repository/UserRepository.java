package yuseteam.mealticketsystemwas.domain.oauthjwt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import yuseteam.mealticketsystemwas.domain.oauthjwt.entity.UserEntity;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

    UserEntity findByName(String name);
    UserEntity findBySocialname(String socialname);
    Optional<UserEntity> findByUserId(String userId);
    Optional<UserEntity> findByPhone(String phone);
    boolean existsByUserId(String userId);
    boolean existsByPhone(String phone);
}
