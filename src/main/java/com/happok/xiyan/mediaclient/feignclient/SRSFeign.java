package com.happok.xiyan.mediaclient.feignclient;

import com.alibaba.fastjson.JSONObject;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "${spring.cloud.client.ip-address}", url = "${streamservice.url}")
public interface SRSFeign {
    @RequestMapping(value = "/streams", method = RequestMethod.GET)
    public JSONObject getStreams();

    @RequestMapping(value = "/streams/{id}", method = RequestMethod.GET)
    public JSONObject getStream(@PathVariable("id") Integer id);

    @RequestMapping(value = "/summaries", method = RequestMethod.GET)
    public JSONObject getSummaries();

    @RequestMapping(value = "/vhosts", method = RequestMethod.GET)
    public JSONObject getVhosts();

    @RequestMapping(value = "/clients", method = RequestMethod.GET)
    public JSONObject getClients();

}