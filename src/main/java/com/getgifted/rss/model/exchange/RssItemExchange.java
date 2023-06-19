package com.getgifted.rss.model.exchange;

import lombok.*;

import java.time.ZonedDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RssItemExchange {
    private Long id;
    private String title;
    private String description;
    private ZonedDateTime publishedDate;
}
