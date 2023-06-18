package com.getgifted.rss.service;


import com.getgifted.rss.RssApplicationTests;
import com.getgifted.rss.model.RssItem;
import com.getgifted.rss.service.impl.RssFeedParserServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.xml.bind.JAXBException;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;


class RssParserServiceTest extends RssApplicationTests {
    @Autowired
    private RssFeedParserServiceImpl rssFeedParserService;

    @Test
    @Order(1)
    public void TEST_parseRssXMLtoRssItemsShouldParseAndReturnListOfRssItems() throws IOException, JAXBException {
        File resource = new File("src/test/resources/test-data.xml");
        byte[] xmlBytes = Files.readAllBytes(Paths.get(resource.getAbsolutePath()));
        List<RssItem> rssItems = rssFeedParserService.parseRssXMLToRssItems(new String(xmlBytes));
        Assertions.assertFalse(rssItems.isEmpty());
        Assertions.assertEquals(2, rssItems.size());
    }

    @Test
    @Order(2)
    public void TEST_parseRssXMLtoRssItemsShouldThrowAnExceptionWhenGivenStringIsNotValid() {
        Assertions.assertThrows(JAXBException.class, () -> {
            rssFeedParserService.parseRssXMLToRssItems("xmlBytes");
        });
    }
}
