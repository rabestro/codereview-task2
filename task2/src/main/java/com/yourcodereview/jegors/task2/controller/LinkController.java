package com.yourcodereview.jegors.task2.controller;

import com.yourcodereview.jegors.task2.dto.GenerateRequest;
import com.yourcodereview.jegors.task2.dto.GenerateResponse;
import com.yourcodereview.jegors.task2.service.LinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class LinkController {
    @Autowired
    LinkService service;

    @PostMapping("generate")
    public GenerateResponse generate(@RequestBody @Valid GenerateRequest request) {
        return new GenerateResponse(service.generate(request.original()));
    }
}
