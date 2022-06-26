package com.yourcodereview.jegors.task2.service.impl

import spock.lang.Specification
import spock.lang.Subject

class ShortUrlServiceImplTest extends Specification {
    @Subject
    def service = new ShortUrlServiceImpl()

    def 'should convert long to short url'() {
        expect:
        service.apply(id) == shortUrl

        where:
        id | shortUrl
        0  | '0'
        1  | '1'
        9  | '9'
        10 | 'a'
    }

    def 'should convert short url to long'() {
        expect:
        service.applyAsLong(shortUrl) == id

        where:
        shortUrl | id
        '0'      | 0
        '1'      | 1
        '9'      | 9
        'a'      | 10
    }
}
