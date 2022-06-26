package com.yourcodereview.jegors.task2.repository;

import com.yourcodereview.jegors.task2.model.History;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HistoryRepository extends JpaRepository<History, Long> {
}
