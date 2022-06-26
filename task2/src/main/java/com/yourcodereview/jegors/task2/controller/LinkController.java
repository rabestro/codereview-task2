package com.yourcodereview.jegors.task2.controller;

import com.yourcodereview.jegors.task2.dto.GenerateRequest;
import com.yourcodereview.jegors.task2.dto.GenerateResponse;
import com.yourcodereview.jegors.task2.service.LinkService;
import com.yourcodereview.jegors.task2.validator.ShortUrl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.validation.Valid;

import static com.yourcodereview.jegors.task2.service.LinkService.LINK_PREFIX;

@RestController
public class LinkController {
    @Autowired
    LinkService service;

    @PostMapping("generate")
    public GenerateResponse generate(@RequestBody @Valid GenerateRequest request) {
        return new GenerateResponse(service.generate(request.original()));
    }

    @GetMapping(LINK_PREFIX + "{shortUrl}")
    public RedirectView redirect(@PathVariable @ShortUrl String shortUrl, RedirectAttributes attributes) {
        attributes.addFlashAttribute("flashAttribute", shortUrl);
        attributes.addAttribute("attribute", shortUrl);
        return service.getOriginalUrl(shortUrl).map(RedirectView::new)
                .orElseThrow();

    }
}
