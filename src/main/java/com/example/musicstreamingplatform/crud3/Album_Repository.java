package com.example.musicstreamingplatform.crud3;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface Album_Repository extends JpaRepository<Album_Entity, Long> {
    
    Page<Album_Entity> findByAlbumNameIn(Pageable pageable, List<String> albumNames);

    @Transactional
    @Modifying
    @Query("DELETE FROM Album_Entity a WHERE a.albumId IN :ids")
    void deleteAlbumsByIds(@Param("ids") List<Long> ids);
}

