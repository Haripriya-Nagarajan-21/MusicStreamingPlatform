package com.example.musicstreamingplatform.crud4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class Playlist_ServiceImpl implements Playlist_Service {

    @Autowired
    private Playlist_Repository playlistRepository;

    @Override
    public String createPlaylist(Playlist_Dto playlistDto) {
        Playlist_Entity playlist = new Playlist_Entity();
        playlist.setPlaylistName(playlistDto.getPlaylistName());
        playlist.setUserId(playlistDto.getUserId());
        playlist.setCreationDate(playlistDto.getCreationDate());
        Playlist_Entity savedPlaylist = playlistRepository.save(playlist);
        return "Playlist Created Successfully with ID: " + savedPlaylist.getPlaylistId();
    }

    @Override
    public Playlist_Dto getPlaylist(Long id) {
        Optional<Playlist_Entity> playlistOptional = playlistRepository.findById(id);
        return playlistOptional.map(this::mapToDto)
                .orElseThrow(() -> new RuntimeException("Playlist not found"));
    }

    @Override
    public String deletePlaylist(Long id) {
        if (playlistRepository.existsById(id)) {
            playlistRepository.deleteById(id);
            return "Playlist Deleted Successfully";
        }
        return "Playlist Not Found";
    }

    @Override
    public String updatePlaylist(Long id, Playlist_Dto playlistDto) {
        Optional<Playlist_Entity> playlistOptional = playlistRepository.findById(id);
        if (playlistOptional.isPresent()) {
            Playlist_Entity playlist = playlistOptional.get();
            playlist.setPlaylistName(playlistDto.getPlaylistName());
            playlist.setUserId(playlistDto.getUserId());
            playlist.setCreationDate(playlistDto.getCreationDate());
            playlistRepository.save(playlist);
            return "Playlist Updated Successfully";
        }
        return "Playlist Not Found";
    }

    @Override
    public Page<Playlist_Dto> getPaginatedPlaylists(Long userId, int page, int size) {
        Page<Playlist_Entity> playlistPage = playlistRepository.findByUserId(userId, PageRequest.of(page, size));
        return playlistPage.map(this::mapToDto);
    }

    @Override
    public String updatePlaylistName(Long id, String newName) {
        if (playlistRepository.existsById(id)) {
            playlistRepository.updatePlaylistName(id, newName);
            return "Playlist Name Updated Successfully";
        }
        return "Playlist Not Found";
    }

    @Override
    public String deletePlaylistsByIds(List<Long> ids) {
        playlistRepository.deletePlaylistsByIds(ids);
        return "Selected Playlists Deleted Successfully";
    }

    private Playlist_Dto mapToDto(Playlist_Entity playlist) {
        Playlist_Dto dto = new Playlist_Dto();
        dto.setPlaylistId(playlist.getPlaylistId());
        dto.setPlaylistName(playlist.getPlaylistName());
        dto.setUserId(playlist.getUserId());
        dto.setCreationDate(playlist.getCreationDate());
        return dto;
    }
}
