package com.yourcodereview.jegors.task2.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;

@Component
public class LinkToShortUrlConverter implements Converter<Long, String> {

    @Override
    public String convert(@NotNull Long source) {
        return Long.toString(source, Character.MAX_RADIX);
    }
}
