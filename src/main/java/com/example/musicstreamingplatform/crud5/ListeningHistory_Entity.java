package com.example.musicstreamingplatform.crud5;

import jakarta.persistence.*;
import lombok.Data;
import java.util.Date;

@Data
@Entity
@Table(name = "listening_history")
public class ListeningHistory_Entity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long historyId;

    private Long userId;
    private Long songId; 
    private String songName;
    private Date playTimestamp;
}
