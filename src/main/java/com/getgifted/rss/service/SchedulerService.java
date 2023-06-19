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

    @Scheduled(fixedRateString = "${scheduler.rss.receiver}")
    private void schedulerRssFeedReceiver() {
        log.info("scheduler => rss feed receiver started.");
        try {
            rssFeedService.updateRssItems();
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        log.info("scheduler => rss feed receiver ended.");
    }

    @Scheduled(fixedRateString = "${scheduler.rss.cleanup}")
    private void schedulerRssFeedCleaner() {
        log.info("scheduler => rss feed cleaner started.");
        rssFeedService.cleanupRssItems();
        log.info("scheduler => rss feed cleaner ended.");
    }


}
