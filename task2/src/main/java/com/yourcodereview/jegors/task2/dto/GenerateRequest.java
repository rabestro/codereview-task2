package com.yourcodereview.jegors.task2.dto;

import org.hibernate.validator.constraints.URL;

public record GenerateRequest(@URL String original) {
}
