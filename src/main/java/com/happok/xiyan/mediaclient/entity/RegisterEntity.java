package com.happok.xiyan.mediaclient.entity;

public class RegisterEntity {
    private String uuid;
    private String type;
    private String server_ip;
    private Integer http_port;
    private Integer rtmp_port;
    private Integer rtsp_port;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


    public String getServer_ip() {
        return server_ip;
    }

    public void setServer_ip(String server_ip) {
        this.server_ip = server_ip;
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

    public Integer getRtsp_port() {
        return rtsp_port;
    }

    public void setRtsp_port(Integer rtsp_port) {
        this.rtsp_port = rtsp_port;
    }
}
