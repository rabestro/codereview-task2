package com.yourcodereview.jegors.task2.controller;

import com.yourcodereview.jegors.task2.model.dto.LinkStats;
import com.yourcodereview.jegors.task2.repository.HistoryRepository;
import com.yourcodereview.jegors.task2.service.StatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController()
public class StatsController {
    @Autowired
    private StatsService statsService;
    @Autowired
    private HistoryRepository historyRepository;

    @GetMapping("stats/{shortUrl}")
    public LinkStats stats(@PathVariable String shortUrl) {
        return statsService.getStats(shortUrl).orElseThrow();
    }

    @GetMapping(value = "stats", params = { "page", "size" })
    public LinkStats allStats(@RequestParam("page") int page, @RequestParam("count") int count) {
        return null;
    }

}
