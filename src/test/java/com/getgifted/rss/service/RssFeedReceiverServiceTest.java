package com.getgifted.rss.service;

import com.getgifted.rss.RssApplicationTests;
import com.getgifted.rss.service.impl.RssFeedReceiverServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.commons.util.StringUtils;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@ExtendWith(MockitoExtension.class)
public class RssFeedReceiverServiceTest extends RssApplicationTests {
    @Mock
    private RestTemplate restTemplate;
    @InjectMocks
    @Autowired
    private RssFeedReceiverServiceImpl rssFeedReceiverService;


    @Test
    @Order(1)
    void TEST_receiveLatestRssFeedAsStringShouldReturnString() {
        Mockito.lenient().when(restTemplate.getForEntity("https://feeds.simplecast.com/54nAGcIl", String.class))
                .thenReturn(new ResponseEntity<>("clientHttpResponse", HttpStatus.OK));
        String latestRssFeedAsString = rssFeedReceiverService.receiveLatestRssFeedAsString();
        Assertions.assertTrue(StringUtils.isNotBlank(latestRssFeedAsString));
    }

    @Test
    @Order(2)
    void TEST_receiveLatestRssFeedAsStringShouldReturnNullWhenRssFeedReturns400() {
        Mockito.lenient().when(restTemplate.getForEntity("https://feeds.simplecast.com/54nAGcIl", String.class))
                .thenReturn(new ResponseEntity<>("clientHttpResponse", HttpStatus.BAD_REQUEST));
        String latestRssFeedAsString = rssFeedReceiverService.receiveLatestRssFeedAsString();
        Assertions.assertTrue(StringUtils.isNotBlank(latestRssFeedAsString));
    }
}
