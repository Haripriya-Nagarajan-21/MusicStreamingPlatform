package com.example.musicstreamingplatform.crud2;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "songs")
public class Song_Entity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long songId;

    private String title;
    private String artist;
    private Long albumId;  
    private String genre;
    private int duration; 
}
