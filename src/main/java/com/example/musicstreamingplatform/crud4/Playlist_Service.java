package com.example.musicstreamingplatform.crud4;

import org.springframework.data.domain.Page;
import java.util.List;

public interface Playlist_Service {
    String createPlaylist(Playlist_Dto playlistDto);
    Playlist_Dto getPlaylist(Long id);
    String deletePlaylist(Long id);
    String updatePlaylist(Long id, Playlist_Dto playlistDto);
    Page<Playlist_Dto> getPaginatedPlaylists(Long userId, int page, int size);
    String updatePlaylistName(Long id, String newName);
    String deletePlaylistsByIds(List<Long> ids);
}
