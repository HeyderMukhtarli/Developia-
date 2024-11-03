package com.developia.balance.repositories;


import com.developia.balance.entity.AuthorityListEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AuthorityListRepository extends JpaRepository<AuthorityListEntity, Long> {


    Optional<AuthorityListEntity> findByAuthority(String authority);
}
