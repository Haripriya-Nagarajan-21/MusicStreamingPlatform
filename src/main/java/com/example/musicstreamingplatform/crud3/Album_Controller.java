package com.example.musicstreamingplatform.crud3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/albums")
@CrossOrigin(origins = "*")
public class Album_Controller {

    @Autowired
    private Album_Service albumService;

    @PostMapping("/create")
    public String createAlbum(@RequestBody Album_Dto albumDto) {
        return albumService.createAlbum(albumDto);
    }

    @GetMapping("/get/{id}")
    public Album_Dto getAlbum(@PathVariable Long id) {
        return albumService.getAlbum(id);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteAlbum(@PathVariable Long id) {
        return albumService.deleteAlbum(id);
    }

    @PutMapping("/update/{id}")
    public String updateAlbum(@PathVariable Long id, @RequestBody Album_Dto albumDto) {
        return albumService.updateAlbum(id, albumDto);
    }

    @GetMapping("/paginated")
    public List<Album_Dto> getPaginatedAlbums(@RequestParam List<String> albumNames) {
        return albumService.getPaginatedAlbums(albumNames);
    }

    @DeleteMapping("/delete-multiple")
    public String deleteAlbumsByIds(@RequestBody List<Long> ids) {
        return albumService.deleteAlbumsByIds(ids);
    }
}
