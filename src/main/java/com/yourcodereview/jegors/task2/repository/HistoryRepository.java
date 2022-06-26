package com.yourcodereview.jegors.task2.repository;

import com.yourcodereview.jegors.task2.model.History;
import com.yourcodereview.jegors.task2.model.projection.LinkStatistics;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface HistoryRepository extends JpaRepository<History, Long> {
    @Query(nativeQuery = true)
    List<LinkStatistics> findAllStats(Pageable pageable);

    @Query(nativeQuery = true)
    Optional<LinkStatistics> findStatsByLinkId(@Param("id") Long id);

}
