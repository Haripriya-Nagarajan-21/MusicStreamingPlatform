package com.example.musicstreamingplatform.crud2;

import java.util.List;

public interface Song_Service {
    String createSong(Song_Dto songDto);
    Song_Dto getSong(Long id);
    String deleteSong(Long id);
    String updateSong(Long id, Song_Dto songDto);
    String updateSongGenre(Long id, String genre);
    List<Song_Dto> getSongsByArtist(String artist);
    List<Song_Dto> getSongsStartingWith(String prefix);
    List<Song_Dto> getSongsEndingWith(String suffix);
    List<Song_Dto> getSongsContaining(String substring);
    List<Song_Dto> getSongsNotContaining(String substring);
    String getWeather(String city);
}
