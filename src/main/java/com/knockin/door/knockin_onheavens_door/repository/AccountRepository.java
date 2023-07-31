package com.knockin.door.knockin_onheavens_door.repository;

import com.knockin.door.knockin_onheavens_door.domain.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<AccountEntity, Long> {

}
