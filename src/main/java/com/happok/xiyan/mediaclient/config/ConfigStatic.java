package com.happok.xiyan.mediaclient.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class ConfigStatic {

    @Autowired
    private SRSMangerConfig SRSMangerConfigAutowired;
    private static SRSMangerConfig srsMangerConfig;

    @Autowired
    private SRSClientConfig srsClientConfigAutowired;
    private static SRSClientConfig srsClientConfig;

    @PostConstruct
    public void init() {
        srsMangerConfig = this.SRSMangerConfigAutowired;
        srsClientConfig = this.srsClientConfigAutowired;
    }

    public static SRSMangerConfig getSRSMangerConfig() {
        return srsMangerConfig;
    }

    public static SRSClientConfig getSRSClientConfig() {
        return srsClientConfig;
    }
}
