package com.example.musicstreamingplatform.crud1;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface URepository extends JpaRepository<UEntity, Long> {
    List<UEntity> findAllByName(Pageable pageable, String name);
    List<UEntity> findAllByNameOrSubscriptionType(Pageable pageable, String name, String subscriptionType);
    
	List<UEntity> findAllByNameAndEmail(Pageable pageable, String name, String email);
}
