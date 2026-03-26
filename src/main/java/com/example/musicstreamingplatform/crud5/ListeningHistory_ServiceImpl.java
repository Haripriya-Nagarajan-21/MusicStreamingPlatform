package com.example.musicstreamingplatform.crud5;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ListeningHistory_ServiceImpl implements ListeningHistory_Service {

    @Autowired
    private ListeningHistory_Repository listeningHistoryRepository;

    @Override
    public String addListeningHistory(ListeningHistory_Dto historyDto) {
        ListeningHistory_Entity history = new ListeningHistory_Entity();
        history.setUserId(historyDto.getUserId());
        history.setSongId(historyDto.getSongId());
        history.setSongName(historyDto.getSongName());
        history.setPlayTimestamp(historyDto.getPlayTimestamp());
        listeningHistoryRepository.save(history);
        return "Listening History Added Successfully";
    }

    @Override
    public ListeningHistory_Dto getListeningHistory(Long id) {
        Optional<ListeningHistory_Entity> historyOptional = listeningHistoryRepository.findById(id);
        if (historyOptional.isPresent()) {
            return mapToDto(historyOptional.get());
        }
        throw new RuntimeException("Listening History not found");
    }

    @Override
    public String deleteListeningHistory(Long id) {
        if (listeningHistoryRepository.existsById(id)) {
            listeningHistoryRepository.deleteById(id);
            return "Listening History Deleted Successfully";
        }
        return "Listening History Not Found";
    }

    @Override
    public String updateListeningHistory(Long id, ListeningHistory_Dto historyDto) {
        Optional<ListeningHistory_Entity> historyOptional = listeningHistoryRepository.findById(id);
        if (historyOptional.isPresent()) {
            ListeningHistory_Entity history = historyOptional.get();
            history.setUserId(historyDto.getUserId());
            history.setSongId(historyDto.getSongId());
            history.setSongName(historyDto.getSongName());
            history.setPlayTimestamp(historyDto.getPlayTimestamp());
            listeningHistoryRepository.save(history);
            return "Listening History Updated Successfully";
        }
        return "Listening History Not Found";
    }

    @Override
    public Page<ListeningHistory_Dto> getPaginatedListeningHistory(Long userId, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return listeningHistoryRepository.findByUserId(userId, pageable).map(this::mapToDto);
    }

    @Override
    public String deleteListeningHistoryByUserId(Long userId) {
        int deletedCount = listeningHistoryRepository.deleteByUserId(userId);
        return deletedCount > 0 ? "Listening History Deleted Successfully" : "No records found for the given user.";
    }

    @Override
    public List<ListeningHistory_Dto> findBySongNameStartingWith(String prefix) {
        return listeningHistoryRepository.findBySongNameStartingWith(prefix).stream().map(this::mapToDto).toList();
    }

    @Override
    public List<ListeningHistory_Dto> findBySongNameEndingWith(String suffix) {
        return listeningHistoryRepository.findBySongNameEndingWith(suffix).stream().map(this::mapToDto).toList();
    }

    private ListeningHistory_Dto mapToDto(ListeningHistory_Entity history) {
        ListeningHistory_Dto historyDto = new ListeningHistory_Dto();
        historyDto.setHistoryId(history.getHistoryId());
        historyDto.setUserId(history.getUserId());
        historyDto.setSongId(history.getSongId());
        historyDto.setSongName(history.getSongName());
        historyDto.setPlayTimestamp(history.getPlayTimestamp());
        return historyDto;
    }
}
