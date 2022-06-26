package com.yourcodereview.jegors.task2.service;

import com.yourcodereview.jegors.task2.model.dto.LinkStats;

import java.util.Optional;

public interface StatsService {

    Optional<LinkStats> getStats(String shortUrl);
}
