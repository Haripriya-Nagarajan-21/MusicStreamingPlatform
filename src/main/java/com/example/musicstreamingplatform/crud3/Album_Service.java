package com.example.musicstreamingplatform.crud3;

import java.util.List;

public interface Album_Service {
    String createAlbum(Album_Dto albumDto);
    Album_Dto getAlbum(Long id);
    String deleteAlbum(Long id);
    String updateAlbum(Long id, Album_Dto albumDto);
    List<Album_Dto> getPaginatedAlbums(List<String> albumNames);
    String deleteAlbumsByIds(List<Long> ids);
}

