package com.example.musicstreamingplatform.crud5;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

public interface ListeningHistory_Repository extends JpaRepository<ListeningHistory_Entity, Long> {
    Page<ListeningHistory_Entity> findByUserId(Long userId, Pageable pageable);

    @Transactional
    int deleteByUserId(Long userId);

    List<ListeningHistory_Entity> findBySongNameStartingWith(String prefix);

    List<ListeningHistory_Entity> findBySongNameEndingWith(String suffix);
}
