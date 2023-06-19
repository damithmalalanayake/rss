package com.getgifted.rss.model.exchange;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Sort;

@Getter
@Setter
public class SearchRssItemExchange {
    private Integer page = 1;
    private Integer size = 10;
    private String sort = "publishedDate";
    private Sort.Direction direction = Sort.Direction.ASC;
}
