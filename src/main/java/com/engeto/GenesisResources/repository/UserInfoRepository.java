package com.engeto.GenesisResources.repository;

import com.engeto.GenesisResources.domain.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface UserInfoRepository extends JpaRepository<UserInfo, Long> {

    boolean existsByPersonIdIgnoreCase(String personId);
}
