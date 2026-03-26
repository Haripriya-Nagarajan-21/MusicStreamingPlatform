package com.example.musicstreamingplatform.crud4;

import jakarta.persistence.*;
import lombok.Data;
import java.util.Date;

@Data
@Entity
@Table(name = "playlists")
public class Playlist_Entity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long playlistId;

    private String playlistName;
    private Long userId;
    private Date creationDate;
}
