package com.example.musicstreamingplatform.crud3;

import jakarta.persistence.*;
import lombok.Data;
import java.util.Date;

@Data
@Entity
@Table(name = "albums")
public class Album_Entity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long albumId;
    private String albumName;
    private Date releaseDate;
    private Long artistId;
}
