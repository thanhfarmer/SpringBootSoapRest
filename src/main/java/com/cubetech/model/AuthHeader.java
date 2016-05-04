package com.cubetech.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(namespace = AuthHeader.AUTH_NS)
public class AuthHeader {

    public static final String AUTH_NS = "http://smsws.org/";

    @XmlElement(namespace = AUTH_NS)
    private String username;
    @XmlElement(namespace = AUTH_NS)
    private String password;

    public AuthHeader() {
    }

    public AuthHeader(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
