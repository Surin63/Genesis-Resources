package com.engeto.GenesisResources.repository;

import com.engeto.GenesisResources.domain.ContactDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface ContactDetailRepository extends JpaRepository<ContactDetail, Long> {
}
