package com.yourcodereview.jegors.task2.service.impl;

import com.yourcodereview.jegors.task2.service.ShortUrlService;
import org.springframework.stereotype.Service;

@Service
public class ShortUrlServiceImpl implements ShortUrlService {
    @Override
    public String apply(long value) {
        return Long.toString(value, Character.MAX_RADIX);
    }

    @Override
    public long applyAsLong(String value) {
        return Long.valueOf(value, Character.MAX_RADIX);
    }
}
