package com.happok.xiyan.mediaclient.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration   //组件类
@ConfigurationProperties(prefix = "client")
public class SRSClientConfig {

    // root: /usr/local/
    // type: live   #(push,live,transcode,notranscode)
    // api_port: 19851
    // http_port: 19451
    // rtmp_port: 19351
    // path: srs_notranscode

    private String root;
    private String type;
    private Integer api_port;
    private Integer http_port;
    private Integer rtmp_port;
    private Integer rtsp_port;
    private String path;
    private String appname;
    private String ip;

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Integer getRtsp_port() {
        return rtsp_port;
    }

    public void setRtsp_port(Integer rtsp_port) {
        this.rtsp_port = rtsp_port;
    }

    public String getAppname() {
        return appname;
    }

    public void setAppname(String appname) {
        this.appname = appname;
    }

    public String getRoot() {
        return root;
    }

    public void setRoot(String root) {
        this.root = root;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getApi_port() {
        return api_port;
    }

    public void setApi_port(Integer api_port) {
        this.api_port = api_port;
    }

    public Integer getHttp_port() {
        return http_port;
    }

    public void setHttp_port(Integer http_port) {
        this.http_port = http_port;
    }

    public Integer getRtmp_port() {
        return rtmp_port;
    }

    public void setRtmp_port(Integer rtmp_port) {
        this.rtmp_port = rtmp_port;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
