package com.getgifted.rss.model.xml;

import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
@Getter
@Setter
public class Owner {
    @XmlElement(name = "itunes:name")
    private String name;

    @XmlElement(name = "itunes:email")
    private String email;
}
