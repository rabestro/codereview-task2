package com.yourcodereview.jegors.task2.service;

import java.util.function.LongFunction;
import java.util.function.ToLongFunction;

public interface ShortUrlService extends ToLongFunction<String>, LongFunction<String> {
}
