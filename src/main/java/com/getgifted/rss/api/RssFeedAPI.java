package com.getgifted.rss.api;

import com.getgifted.rss.model.exchange.PageExchange;
import com.getgifted.rss.model.exchange.RssItemExchange;
import com.getgifted.rss.model.exchange.SearchRssItemExchange;
import com.getgifted.rss.service.RssFeedService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/rss")
public class RssFeedAPI {
    private final RssFeedService rssFeedService;

    public RssFeedAPI(RssFeedService rssFeedService) {
        this.rssFeedService = rssFeedService;
    }

    @GetMapping("/items")
    public ResponseEntity<PageExchange<RssItemExchange>> getRssItems(SearchRssItemExchange searchRssItemExchange) {
        PageExchange<RssItemExchange> rssItemPageExchange = rssFeedService.getRssItemPageExchange(searchRssItemExchange);
        return ResponseEntity.ok(rssItemPageExchange);
    }
}
