package com.getgifted.rss.service.impl;

import com.getgifted.rss.model.RssItem;
import com.getgifted.rss.model.xml.Rss;
import com.getgifted.rss.service.RssFeedParserService;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RssFeedParserServiceImpl implements RssFeedParserService {
    @Override
    public List<RssItem> parseRssXMLToRssItems(String xml) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(Rss.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        Rss rss = (Rss) jaxbUnmarshaller.unmarshal(new StringReader(xml));
        return rss.getChannel().getItems().parallelStream().map(item -> RssItem.builder()
                .title(item.getTitle())
                .description(item.getDescription())
                .publishedDate(ZonedDateTime.parse(item.getPubDate(), DateTimeFormatter.RFC_1123_DATE_TIME))
                .build()).collect(Collectors.toList());
    }
}
