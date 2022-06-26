package com.yourcodereview.jegors.task2.repository;

import com.yourcodereview.jegors.task2.model.Link;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LinkRepository extends JpaRepository<Link, Long> {

    Optional<Link> findByOriginal(String original);
}
