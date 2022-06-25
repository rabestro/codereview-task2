package com.yourcodereview.jegors.task2.config;

import com.yourcodereview.jegors.task2.converter.LinkToShortUrlConverter;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(new LinkToShortUrlConverter());
    }
}
