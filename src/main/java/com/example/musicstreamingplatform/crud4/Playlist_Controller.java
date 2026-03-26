package com.example.musicstreamingplatform.crud4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/playlists")
@CrossOrigin(origins = "*")
public class Playlist_Controller {

    @Autowired
    private Playlist_Service playlistService;

    @PostMapping("/create")
    public String createPlaylist(@RequestBody Playlist_Dto playlistDto) {
        return playlistService.createPlaylist(playlistDto);
    }

    @GetMapping("/get/{id}")
    public Playlist_Dto getPlaylist(@PathVariable Long id) {
        return playlistService.getPlaylist(id);
    }

    @DeleteMapping("/delete/{id}")
    public String deletePlaylist(@PathVariable Long id) {
        return playlistService.deletePlaylist(id);
    }

    @PutMapping("/update/{id}")
    public String updatePlaylist(@PathVariable Long id, @RequestBody Playlist_Dto playlistDto) {
        return playlistService.updatePlaylist(id, playlistDto);
    }

    @GetMapping("/paginated")
    public Page<Playlist_Dto> getPaginatedPlaylists(
            @RequestParam Long userId,
            @RequestParam int page,
            @RequestParam int size) {
        return playlistService.getPaginatedPlaylists(userId, page, size);
    }

    @PutMapping("/update-name/{id}")
    public String updatePlaylistName(@PathVariable Long id, @RequestParam String newName) {
        return playlistService.updatePlaylistName(id, newName);
    }

    @DeleteMapping("/delete-multiple")
    public String deletePlaylistsByIds(@RequestBody List<Long> ids) {
        return playlistService.deletePlaylistsByIds(ids);
    }
}
