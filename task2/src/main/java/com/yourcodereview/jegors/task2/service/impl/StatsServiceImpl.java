package com.yourcodereview.jegors.task2.service.impl;

import com.yourcodereview.jegors.task2.model.dto.LinkStats;
import com.yourcodereview.jegors.task2.repository.HistoryRepository;
import com.yourcodereview.jegors.task2.service.ShortUrlService;
import com.yourcodereview.jegors.task2.service.StatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static com.yourcodereview.jegors.task2.service.LinkService.LINK_PREFIX;

@Service
public class StatsServiceImpl implements StatsService {
    @Autowired
    private HistoryRepository historyRepository;
    @Autowired
    private ShortUrlService shortUrlService;

    @Override
    public Optional<LinkStats> getStats(String shortUrl) {
        var id = shortUrlService.applyAsLong(shortUrl);
        return historyRepository
                .findStatsByLinkId(id)
                .map(stats -> new LinkStats(
                        LINK_PREFIX + shortUrl,
                        stats.getOriginal(),
                        stats.getRank(),
                        stats.getCount())
                );
    }
}
