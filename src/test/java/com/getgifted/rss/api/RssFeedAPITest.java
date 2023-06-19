package com.getgifted.rss.api;

import com.getgifted.rss.RssApplicationTests;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
public class RssFeedAPITest extends RssApplicationTests {
    @Autowired
    MockMvc mock;

    @Test
    void TEST_rssItemsAPIShouldListItemsWhenNoParameterGiven() throws Exception {
        this.mock.perform(get("/api/rss/items")
                        .contentType(MediaType.APPLICATION_JSON)).andDo(print())
                .andExpect(status().isOk());
    }
}
