package com.sf.hop;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

@Component
@RefreshScope
public class ServiceConfig{
  
    @Value("${application.feature1}")
    private String appFeature1;

    @Value("${application.env.feature1}")
    private String appEnvFeature1;
    
    @Value("${service.feature1}")
    private String serviceFeature1;

    @Value("${service.env.feature1}")
    private String serviceEnvFeature1;

    @Value("${vault_key1}")
    private String key1;

    @Value("${vault_key2}")
    private String key2;
    
    public String getAppFeature1() {
        return appFeature1;
    }

    public String getAppEnvFeature1() {
        return appEnvFeature1;
    }

    public String getServiceFeature1() {
        return serviceFeature1;
    }

    public String getServiceEnvFeature1() {
        return serviceEnvFeature1;
    }
  
    public String getKey1() {
        return key1;
    }

    public String getKey2() {
        return key2;
    }
    
}