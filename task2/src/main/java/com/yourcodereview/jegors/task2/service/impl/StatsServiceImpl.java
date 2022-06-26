package com.yourcodereview.jegors.task2.service.impl;

import com.yourcodereview.jegors.task2.model.projection.LinkStatistics;
import com.yourcodereview.jegors.task2.repository.HistoryRepository;
import com.yourcodereview.jegors.task2.service.ShortUrlService;
import com.yourcodereview.jegors.task2.service.StatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StatsServiceImpl implements StatsService {
    @Autowired
    private HistoryRepository historyRepository;
    @Autowired
    private ShortUrlService shortUrlService;

    @Override
    public Optional<LinkStatistics> getStats(String shortUrl) {
        var id = shortUrlService.applyAsLong(shortUrl);
        return historyRepository.findStatsByLinkId(id);
    }

    @Override
    public List<LinkStatistics> getAllStats() {
        return historyRepository.findAllStats();
    }


}
