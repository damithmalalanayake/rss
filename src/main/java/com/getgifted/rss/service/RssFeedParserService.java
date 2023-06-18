package com.getgifted.rss.service;

import com.getgifted.rss.model.RssItem;

import javax.xml.bind.JAXBException;
import java.util.List;

public interface RssFeedParserService {
    List<RssItem> parseRssXMLToRssItems(String xml) throws JAXBException;
}
