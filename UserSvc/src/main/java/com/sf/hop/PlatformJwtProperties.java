package com.sf.hop;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix="platform.jwt")
public class PlatformJwtProperties {
    private String key;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
