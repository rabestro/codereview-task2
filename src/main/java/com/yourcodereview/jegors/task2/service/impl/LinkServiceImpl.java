package com.yourcodereview.jegors.task2.service.impl;

import com.yourcodereview.jegors.task2.model.History;
import com.yourcodereview.jegors.task2.model.Link;
import com.yourcodereview.jegors.task2.repository.HistoryRepository;
import com.yourcodereview.jegors.task2.repository.LinkRepository;
import com.yourcodereview.jegors.task2.service.LinkService;
import com.yourcodereview.jegors.task2.service.ShortUrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.function.Supplier;

import static java.util.Objects.requireNonNull;

@Service
public class LinkServiceImpl implements LinkService {
    @Autowired
    private LinkRepository linkRepository;
    @Autowired
    private HistoryRepository historyRepository;
    @Autowired
    private ShortUrlService shortUrlService;

    @Override
    public String generate(String original) {
        Supplier<Link> newShortUrl = () -> linkRepository.save(new Link(original));

        var link = linkRepository
                .findByOriginal(original)
                .orElseGet(newShortUrl);

        var id = requireNonNull(link.getId());

        return LINK_PREFIX + shortUrlService.apply(id);
    }

    @Override
    public Optional<String> getOriginalUrl(String shortUrl) {
        var id = shortUrlService.applyAsLong(shortUrl);
        var link = linkRepository.findById(id);
        link.ifPresent(this::saveHistory);
        return link.map(Link::getOriginal);
    }

    private void saveHistory(Link link) {
        historyRepository.save(new History(link));
    }
}
