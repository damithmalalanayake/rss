package com.getgifted.rss.model.xml;

import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@Getter
@Setter
public class Channel {
    @XmlElement(name = "title")
    private String title;

    @XmlElement(name = "description")
    private String description;

    @XmlElement(name = "managingEditor")
    private String managingEditor;

    @XmlElement(name = "copyright")
    private String copyright;

    @XmlElement(name = "generator")
    private String generator;

    @XmlElement(name = "link")
    private String link;

    @XmlElement(name = "language")
    private String language;

    @XmlElement(name = "itunes:owner")
    private Owner owner;

    @XmlElement(name = "itunes:author")
    private String author;

    @XmlElement(name = "itunes:summary")
    private String summary;

    @XmlElement(name = "itunes:explicit")
    private String explicit;

    @XmlElement(name = "itunes:category")
    private Category category;

    @XmlElement(name = "itunes:keywords")
    private String keywords;

    @XmlElement(name = "itunes:type")
    private String type;

    @XmlElement(name = "itunes:image")
    private Image image;

    @XmlElement(name = "image")
    private Image rssImage;

    @XmlElement(name = "item")
    private List<Item> items;
}
