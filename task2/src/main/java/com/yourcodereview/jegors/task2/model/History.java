package com.yourcodereview.jegors.task2.model;

import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.Instant;

@Entity
public class History extends AbstractPersistable<Long> {

    @Column(nullable = false, updatable = false)
    private Instant date = Instant.now();

    @ManyToOne
    @JoinColumn(name = "link_id")
    private Link link;

    public History() {
    }

    public History(Link link) {
        this.link = link;
    }

    public Link getLink() {
        return link;
    }

    public void setLink(Link link) {
        this.link = link;
    }
}
