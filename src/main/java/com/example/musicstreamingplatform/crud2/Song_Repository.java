package com.example.musicstreamingplatform.crud2;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface Song_Repository extends JpaRepository<Song_Entity, Long> {
    List<Song_Entity> findSongsByArtist(String artist);
    List<Song_Entity> findByTitleStartingWith(String prefix);
    List<Song_Entity> findByTitleEndingWith(String suffix);
    List<Song_Entity> findByTitleContaining(String substring);
    List<Song_Entity> findByTitleNotContaining(String substring);

    @Transactional
    @Modifying
    @Query("UPDATE Song_Entity s SET s.genre = :genre WHERE s.songId = :id")
    int updateSongGenre(@Param("id") Long id, @Param("genre") String genre);
}
