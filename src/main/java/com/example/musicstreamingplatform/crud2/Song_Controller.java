package com.example.musicstreamingplatform.crud2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/songs")
@CrossOrigin(origins = "*")
public class Song_Controller {

    @Autowired
    private Song_Service songService;

    @PostMapping("/create")
    public String createSong(@RequestBody Song_Dto songDto) {
        return songService.createSong(songDto);
    }

    @GetMapping("/get/{id}")
    public Song_Dto getSong(@PathVariable Long id) {
        return songService.getSong(id);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteSong(@PathVariable Long id) {
        return songService.deleteSong(id);
    }

    @PutMapping("/update/{id}")
    public String updateSong(@PathVariable Long id, @RequestBody Song_Dto songDto) {
        return songService.updateSong(id, songDto);
    }

    @PutMapping("/updateGenre/{id}")
    public String updateGenre(@PathVariable Long id, @RequestParam String genre) {
        return songService.updateSongGenre(id, genre);
    }

    @GetMapping("/artist/{artist}")
    public List<Song_Dto> getSongsByArtist(@PathVariable String artist) {
        return songService.getSongsByArtist(artist);
    }

    @GetMapping("/title/start/{prefix}")
    public List<Song_Dto> getSongsStartingWith(@PathVariable String prefix) {
        return songService.getSongsStartingWith(prefix);
    }

    @GetMapping("/title/end/{suffix}")
    public List<Song_Dto> getSongsEndingWith(@PathVariable String suffix) {
        return songService.getSongsEndingWith(suffix);
    }

    @GetMapping("/weather")
    public String getWeather(@RequestParam String city) {
        return songService.getWeather(city);
    }
}
