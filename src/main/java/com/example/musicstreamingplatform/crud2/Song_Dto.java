package com.example.musicstreamingplatform.crud2;

import lombok.Data;

@Data
public class Song_Dto {
    private Long songId;
    private String title;
    private String artist;
    private Long albumId;
    private String genre;
    private int duration;
}
