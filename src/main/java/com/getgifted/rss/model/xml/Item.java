package com.getgifted.rss.model.xml;

import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
@Getter
@Setter
public class Item {
    @XmlElement(name = "title")
    private String title;

    @XmlElement(name = "description")
    private String description;

    @XmlElement(name = "itunes:title")
    private String itunesTitle;

    @XmlElement(name = "itunes:episodeType")
    private String episodeType;

    @XmlElement(name = "itunes:summary")
    private String summary;

    @XmlElement(name = "content:encoded")
    private String contentEncoded;

    @XmlElement(name = "guid")
    private String guid;

    @XmlElement(name = "pubDate")
    private String pubDate;

    @XmlElement(name = "itunes:explicit")
    private String explicit;

    @XmlElement(name = "itunes:image")
    private Image itemImage;

    @XmlElement(name = "itunes:keywords")
    private String keywords;

    @XmlElement(name = "itunes:duration")
    private String duration;

    @XmlElement(name = "enclosure")
    private Enclosure enclosure;
}
