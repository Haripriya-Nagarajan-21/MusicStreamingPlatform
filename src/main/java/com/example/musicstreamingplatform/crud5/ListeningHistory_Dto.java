package com.example.musicstreamingplatform.crud5;

import lombok.Data;
import java.util.Date;

@Data
public class ListeningHistory_Dto {
    private Long historyId;
    private Long userId;
    private Long songId;
    private String songName;
    private Date playTimestamp;
}
