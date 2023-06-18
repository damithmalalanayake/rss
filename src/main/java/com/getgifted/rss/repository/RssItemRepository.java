package com.getgifted.rss.repository;

import com.getgifted.rss.model.RssItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RssItemRepository extends JpaRepository<RssItem, Long> {
    Optional<RssItem> findByTitle(String title);
}
