package com.getgifted.rss.model.xml;

import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
@Getter
@Setter
public class Image {
    @XmlElement(name = "url")
    private String url;

    @XmlElement(name = "link")
    private String link;

    @XmlElement(name = "title")
    private String title;
}
