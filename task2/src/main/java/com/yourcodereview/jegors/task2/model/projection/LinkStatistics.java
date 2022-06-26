package com.yourcodereview.jegors.task2.model.projection;

import static com.yourcodereview.jegors.task2.service.LinkService.LINK_PREFIX;

public interface LinkStatistics {
    long getId();

    String getOriginal();

    long getRank();

    long getCount();

    default String getLink() {
        return LINK_PREFIX + Long.toString(getId(), Character.MAX_RADIX);
    }

}
