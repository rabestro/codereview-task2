package com.yourcodereview.jegors.task2.controller;

import com.yourcodereview.jegors.task2.exception.UrlNotFoundException;
import com.yourcodereview.jegors.task2.model.projection.LinkStatistics;
import com.yourcodereview.jegors.task2.service.StatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.List;

@RestController()
public class StatsController {
    @Autowired
    private StatsService statsService;

    @GetMapping("stats/{shortUrl}")
    public LinkStatistics stats(@PathVariable String shortUrl) {
        return statsService
                .getStats(shortUrl)
                .orElseThrow(UrlNotFoundException::new);
    }

    @GetMapping(value = "stats")
    public List<LinkStatistics> allStats(
            @RequestParam(value = "page", defaultValue = "0", required = false) @Min(0) int page,
            @RequestParam(value = "count", defaultValue = "5", required = false) @Min(2) @Max(100) int count) {
        var paging = PageRequest.of(page, count);
        return statsService.getAllStats(paging);
    }

}
