package com.example.musicstreamingplatform.crud5;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/listening-history")
@CrossOrigin(origins = "*")
public class ListeningHistory_Controller {

    @Autowired
    private ListeningHistory_Service listeningHistoryService;

    @PostMapping("/add")
    public String addListeningHistory(@RequestBody ListeningHistory_Dto historyDto) {
        return listeningHistoryService.addListeningHistory(historyDto);
    }

    @GetMapping("/get/{id}")
    public ListeningHistory_Dto getListeningHistory(@PathVariable Long id) {
        return listeningHistoryService.getListeningHistory(id);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteListeningHistory(@PathVariable Long id) {
        return listeningHistoryService.deleteListeningHistory(id);
    }

    @PutMapping("/update/{id}")
    public String updateListeningHistory(@PathVariable Long id, @RequestBody ListeningHistory_Dto historyDto) {
        return listeningHistoryService.updateListeningHistory(id, historyDto);
    }

    @GetMapping("/paginated")
    public Page<ListeningHistory_Dto> getPaginatedListeningHistory(@RequestParam Long userId, @RequestParam int page, @RequestParam int size) {
        return listeningHistoryService.getPaginatedListeningHistory(userId, page, size);
    }

    @DeleteMapping("/delete-by-user/{userId}")
    public String deleteListeningHistoryByUserId(@PathVariable Long userId) {
        return listeningHistoryService.deleteListeningHistoryByUserId(userId);
    }

    @GetMapping("/find-starting")
    public List<ListeningHistory_Dto> findBySongNameStartingWith(@RequestParam String prefix) {
        return listeningHistoryService.findBySongNameStartingWith(prefix);
    }

    @GetMapping("/find-ending")
    public List<ListeningHistory_Dto> findBySongNameEndingWith(@RequestParam String suffix) {
        return listeningHistoryService.findBySongNameEndingWith(suffix);
    }
}
