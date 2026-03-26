package com.example.musicstreamingplatform.crud4;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

public interface Playlist_Repository extends JpaRepository<Playlist_Entity, Long> {
    Page<Playlist_Entity> findByUserId(Long userId, Pageable pageable);

    @Modifying
    @Transactional
    @Query("UPDATE Playlist_Entity p SET p.playlistName = :playlistName WHERE p.playlistId = :playlistId")
    void updatePlaylistName(Long playlistId, String playlistName);

    @Modifying
    @Transactional
    @Query("DELETE FROM Playlist_Entity p WHERE p.playlistId IN :ids")
    void deletePlaylistsByIds(List<Long> ids);
}
