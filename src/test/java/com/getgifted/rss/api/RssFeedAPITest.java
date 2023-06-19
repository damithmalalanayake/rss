package com.getgifted.rss.api;

import com.getgifted.rss.RssApplicationTests;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
public class RssFeedAPITest extends RssApplicationTests {
    @Autowired
    MockMvc mock;

    @Test
    void TEST_rssItemsAPIShouldListItemsWhenNoParameterGiven() throws Exception {
        this.mock.perform(get("/api/rss/items")
                        .contentType(MediaType.APPLICATION_JSON)).andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.totalItems", Matchers.equalTo(7)));
    }

    @Test
    void TEST_rssItemsAPIShouldGet3PagesWhenPageSizeIs3() throws Exception {
        this.mock.perform(get("/api/rss/items")
                        .param("size", "3")
                        .contentType(MediaType.APPLICATION_JSON)).andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.totalPages", Matchers.equalTo(3)));
    }

    @Test
    void TEST_rssItemsAPIShouldListItemsWhenPublishedDateGivenAsSortAndDirectionDesc() throws Exception {
        this.mock.perform(get("/api/rss/items")
                        .param("direction", "DESC")
                        .param("sort", "publishedDate")
                        .contentType(MediaType.APPLICATION_JSON)).andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.items[0].id", Matchers.equalTo(7)));
    }

}
