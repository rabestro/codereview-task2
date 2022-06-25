package com.yourcodereview.jegors.task2.model;

import org.hibernate.validator.constraints.URL;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.Entity;

@Entity
public class Link extends AbstractPersistable<Long> {
    @URL
    private String original;

    public Link() {
    }

    public Link(String original) {
        this.original = original;
    }

    public String getOriginal() {
        return original;
    }

    public void setOriginal(String link) {
        this.original = link;
    }

}
