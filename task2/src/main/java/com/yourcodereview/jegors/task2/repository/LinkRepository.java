package com.yourcodereview.jegors.task2.repository;

import com.yourcodereview.jegors.task2.model.Link;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LinkRepository extends JpaRepository<Link, Long> {

    Optional<Link> findByOriginal(String original);
}
