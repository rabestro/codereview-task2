package com.yourcodereview.jegors.task2.service;

import com.yourcodereview.jegors.task2.model.projection.LinkStatistics;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface StatsService {

    Optional<LinkStatistics> getStats(String shortUrl);

    List<LinkStatistics> getAllStats(Pageable pageable);
}
