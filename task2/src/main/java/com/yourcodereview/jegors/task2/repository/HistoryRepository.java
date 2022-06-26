package com.yourcodereview.jegors.task2.repository;

import com.yourcodereview.jegors.task2.model.History;
import com.yourcodereview.jegors.task2.model.projection.LinkStatistics;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.util.Streamable;

import java.util.Optional;

public interface HistoryRepository extends JpaRepository<History, Long> {
    @Query(nativeQuery = true)
    Streamable<LinkStatistics> findAllStats();

    @Query(nativeQuery = true)
    Optional<LinkStatistics> findStatsByLinkId(@Param("id") Long id);

}
