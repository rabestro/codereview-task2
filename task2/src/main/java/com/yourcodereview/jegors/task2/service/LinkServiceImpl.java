package com.yourcodereview.jegors.task2.service;

import com.yourcodereview.jegors.task2.model.Link;
import com.yourcodereview.jegors.task2.repository.LinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

@Service
public class LinkServiceImpl implements LinkService {
    @Autowired
    private LinkRepository repository;

    @Autowired
    private ConversionService conversionService;

    @Override
    public String generate(String original) {
        var link = repository.findByOriginal(original)
                .orElseGet(() -> repository.save(new Link(original)));

        return conversionService.convert(link, String.class);
    }
}
