package com.yourcodereview.jegors.task2.converter;

import com.yourcodereview.jegors.task2.model.Link;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;

@Component
public class LinkToShortUrlConverter implements Converter<Link, String> {
    
    @Override
    public String convert(@NotNull Link source) {
        return Long.toString(source.getId(), Character.MAX_RADIX);
    }
}
