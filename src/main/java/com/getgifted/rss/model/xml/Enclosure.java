package com.getgifted.rss.model.xml;

import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

@XmlAccessorType(XmlAccessType.FIELD)
@Getter
@Setter
public class Enclosure {
    @XmlAttribute(name = "url")
    private String url;

    @XmlAttribute(name = "type")
    private String type;

    @XmlAttribute(name = "length")
    private long length;

}
