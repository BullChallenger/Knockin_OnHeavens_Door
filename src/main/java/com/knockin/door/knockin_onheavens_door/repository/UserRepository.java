package com.knockin.door.knockin_onheavens_door.repository;

import com.knockin.door.knockin_onheavens_door.domain.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

    Optional<UserEntity> findByUserId(Long userId);

    Optional<UserEntity> findByEmail(String email);
}
