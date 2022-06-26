package com.yourcodereview.jegors.task2.service;

import java.util.Optional;

public interface LinkService {
    String LINK_PREFIX = "/l/";

    String generate(String original);

    Optional<String> getOriginalUrl(String shortUrl);
}
