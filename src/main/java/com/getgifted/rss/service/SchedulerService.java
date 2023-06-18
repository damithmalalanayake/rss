package com.getgifted.rss.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;

@Slf4j
@Service
public class SchedulerService {
    private final RssFeedService rssFeedService;

    public SchedulerService(RssFeedService rssFeedService) {
        this.rssFeedService = rssFeedService;
    }

    @Scheduled(fixedRate = 15000)
    private void schedulerRssFeedReceiver() {
        log.info("scheduler => rss feed receiver started.");
        try {
            rssFeedService.updateRssItems();
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        log.info("scheduler => rss feed receiver ended.");
    }


}
