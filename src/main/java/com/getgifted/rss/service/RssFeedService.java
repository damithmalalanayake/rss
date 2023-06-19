package com.getgifted.rss.service;

import com.getgifted.rss.model.RssItem;
import com.getgifted.rss.model.exchange.PageExchange;
import com.getgifted.rss.model.exchange.RssItemExchange;
import com.getgifted.rss.model.exchange.SearchRssItemExchange;
import com.getgifted.rss.repository.RssItemRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.xml.bind.JAXBException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    public PageExchange<RssItemExchange> getRssItemPageExchange(SearchRssItemExchange searchRssItemExchange) {
        Pageable pageable = PageRequest.of(searchRssItemExchange.getPage() - 1, searchRssItemExchange.getSize(), searchRssItemExchange.getDirection(), searchRssItemExchange.getSort());
        Page<RssItem> items = rssItemRepository.findAll(pageable);
        return buildRssItemPageExchange(searchRssItemExchange.getPage(), searchRssItemExchange.getSize(), items);
    }

    private PageExchange<RssItemExchange> buildRssItemPageExchange(int page, int size, Page<RssItem> rssItemsPage) {
        return PageExchange.<RssItemExchange>builder()
                .page(page)
                .pageSize(size)
                .items(buildRssItemExchanges(rssItemsPage.getContent()))
                .totalItems(rssItemsPage.getTotalElements())
                .totalPages(rssItemsPage.getTotalPages()).build();
    }

    private List<RssItemExchange> buildRssItemExchanges(List<RssItem> rssItems) {
        return CollectionUtils.isEmpty(rssItems) ? null : rssItems.stream().map(this::buildRssItemExchange).collect(Collectors.toList());
    }

    private RssItemExchange buildRssItemExchange(RssItem rssItem) {
        return RssItemExchange.builder()
                .id(rssItem.getId())
                .description(rssItem.getDescription())
                .publishedDate(rssItem.getPublishedDate())
                .build();
    }
}
