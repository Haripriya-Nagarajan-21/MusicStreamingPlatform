package com.example.musicstreamingplatform.crud4;

import lombok.Data;
import java.util.Date;

@Data
public class Playlist_Dto {
    private Long playlistId;
    private String playlistName;
    private Long userId;
    private Date creationDate;
}
