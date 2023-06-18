package com.getgifted.rss.service;

import com.getgifted.rss.model.RssItem;
import com.getgifted.rss.repository.RssItemRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.xml.bind.JAXBException;
import java.util.List;
import java.util.Optional;

@Service
public class RssFeedService {
    private final RssFeedReceiverService rssFeedReceiverService;
    private final RssItemRepository rssItemRepository;
    private final RssFeedParserService rssFeedParserService;

    public RssFeedService(RssFeedReceiverService rssFeedReceiverService, RssItemRepository rssItemRepository, RssFeedParserService rssFeedParserService) {
        this.rssFeedReceiverService = rssFeedReceiverService;
        this.rssItemRepository = rssItemRepository;
        this.rssFeedParserService = rssFeedParserService;
    }

    public void updateRssItems() throws JAXBException {
        String rssFeedAsString = rssFeedReceiverService.receiveLatestRssFeedAsString();
        List<RssItem> rssItems = rssFeedParserService.parseRssXMLToRssItems(rssFeedAsString);
        if (!CollectionUtils.isEmpty(rssItems)) {
            rssItems.parallelStream().forEach(rssItem -> {
                Optional<RssItem> rssItemOptional = rssItemRepository.findByTitle(rssItem.getTitle());
                if (rssItemOptional.isEmpty()) {
                    rssItemRepository.save(rssItem);
                }
            });
        }
    }
}
