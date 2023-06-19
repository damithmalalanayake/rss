package com.getgifted.rss.service;

import com.getgifted.rss.model.exchange.PageExchange;
import com.getgifted.rss.model.exchange.RssItemExchange;
import com.getgifted.rss.model.exchange.SearchRssItemExchange;

import javax.xml.bind.JAXBException;

public interface RssFeedService {
    void updateRssItems() throws JAXBException;

    PageExchange<RssItemExchange> getRssItemPageExchange(SearchRssItemExchange searchRssItemExchange);

    void cleanupRssItems();
}
