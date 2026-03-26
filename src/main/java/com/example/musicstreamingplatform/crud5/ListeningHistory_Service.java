package com.example.musicstreamingplatform.crud5;

import org.springframework.data.domain.Page;
import java.util.List;

public interface ListeningHistory_Service {
    String addListeningHistory(ListeningHistory_Dto historyDto);
    ListeningHistory_Dto getListeningHistory(Long id);
    String deleteListeningHistory(Long id);
    String updateListeningHistory(Long id, ListeningHistory_Dto historyDto);
    Page<ListeningHistory_Dto> getPaginatedListeningHistory(Long userId, int page, int size);
    String deleteListeningHistoryByUserId(Long userId);
    List<ListeningHistory_Dto> findBySongNameStartingWith(String prefix);
    List<ListeningHistory_Dto> findBySongNameEndingWith(String suffix);
}
