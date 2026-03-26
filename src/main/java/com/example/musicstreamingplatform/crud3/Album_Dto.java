package com.example.musicstreamingplatform.crud3;

import lombok.Data;
import java.util.Date;

@Data
public class Album_Dto {
    private Long albumId;
    private String albumName;
    private Date releaseDate;
    private Long artistId;
}
