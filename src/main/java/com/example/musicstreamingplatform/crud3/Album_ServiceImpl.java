package com.example.musicstreamingplatform.crud3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class Album_ServiceImpl implements Album_Service {

    @Autowired
    private Album_Repository albumRepository;

    @Override
    public String createAlbum(Album_Dto albumDto) {
        Album_Entity album = new Album_Entity();
        album.setAlbumName(albumDto.getAlbumName());
        album.setReleaseDate(albumDto.getReleaseDate());
        album.setArtistId(albumDto.getArtistId());
        
        Album_Entity savedAlbum = albumRepository.save(album); // Save and get generated ID
        return "Album Created Successfully with ID: " + savedAlbum.getAlbumId();
    }

    @Override
    public Album_Dto getAlbum(Long id) {
        Optional<Album_Entity> albumOptional = albumRepository.findById(id);
        return albumOptional.map(this::mapToDto)
                .orElseThrow(() -> new RuntimeException("Album not found"));
    }

    @Override
    public String deleteAlbum(Long id) {
        if (albumRepository.existsById(id)) {
            albumRepository.deleteById(id);
            return "Album Deleted Successfully";
        }
        return "Album Not Found";
    }

    @Override
    public String updateAlbum(Long id, Album_Dto albumDto) {
        Optional<Album_Entity> albumOptional = albumRepository.findById(id);
        if (albumOptional.isPresent()) {
            Album_Entity album = albumOptional.get();
            album.setAlbumName(albumDto.getAlbumName());
            album.setReleaseDate(albumDto.getReleaseDate());
            album.setArtistId(albumDto.getArtistId());
            albumRepository.save(album);
            return "Album Updated Successfully";
        }
        return "Album Not Found";
    }

    @Override
    public List<Album_Dto> getPaginatedAlbums(List<String> albumNames) {
        Pageable pageable = PageRequest.of(0, 5);
        Page<Album_Entity> albumsPage = albumRepository.findByAlbumNameIn(pageable, albumNames);
        return albumsPage.getContent().stream()
                         .map(this::mapToDto)
                         .collect(Collectors.toList());
    }

    @Override
    public String deleteAlbumsByIds(List<Long> ids) {
        albumRepository.deleteAlbumsByIds(ids);
        return "Albums Deleted Successfully";
    }

    private Album_Dto mapToDto(Album_Entity album) {
        Album_Dto albumDto = new Album_Dto();
        albumDto.setAlbumId(album.getAlbumId());
        albumDto.setAlbumName(album.getAlbumName());
        albumDto.setReleaseDate(album.getReleaseDate());
        albumDto.setArtistId(album.getArtistId());
        return albumDto;
    }
}
