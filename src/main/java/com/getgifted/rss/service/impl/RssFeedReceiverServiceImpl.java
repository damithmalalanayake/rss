package com.getgifted.rss.service.impl;

import com.getgifted.rss.service.RssFeedReceiverService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RssFeedReceiverServiceImpl implements RssFeedReceiverService {
    private final RestTemplate restTemplate;

    public RssFeedReceiverServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public String receiveLatestRssFeedAsString() {
        ResponseEntity<String> responseEntity = restTemplate.getForEntity("https://feeds.simplecast.com/54nAGcIl", String.class);
        if (responseEntity.getStatusCode().is2xxSuccessful()) {
            return responseEntity.getBody();
        }
        return null;
    }
}
