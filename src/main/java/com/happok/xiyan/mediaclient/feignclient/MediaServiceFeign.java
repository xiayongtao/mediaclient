package com.happok.xiyan.mediaclient.feignclient;

import com.alibaba.fastjson.JSONObject;
import com.happok.xiyan.mediaclient.entity.RegisterEntity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;

@FeignClient(name = "MEDIASERVICE")
public interface MediaServiceFeign {

    // register
    // 添加流媒体
    @RequestMapping(value = "/mediaservice/register/clients", method = RequestMethod.POST)
    public JSONObject RegeditClient(@RequestBody RegisterEntity registerEntity);

    // 修改流媒体
    @RequestMapping(value = "/mediaservice/register/clients/{uuid}", method = RequestMethod.PUT)
    public JSONObject updateClient(@PathVariable("uuid") String uuid, @RequestBody LinkedHashMap<String, String> param);

    // 删除流媒体
    @RequestMapping(value = "/mediaservice/register/clients/{uuid}", method = RequestMethod.DELETE)
    public JSONObject deleteClient(@PathVariable("uuid") String uuid);

    // 查询流媒体
    @RequestMapping(value = "/mediaservice/register/clients", method = RequestMethod.GET)
    public JSONObject getClients();

    // 查询指定流媒体
    @RequestMapping(value = "/mediaservice/register/clients/{uuid}", method = RequestMethod.GET)
    public JSONObject getClient(@PathVariable("uuid") String uuid);


    //clients
    // 更新状态信息
    @RequestMapping(value = "/mediaservice/clients/{uuid}", method = RequestMethod.POST)
    public JSONObject updateStatusClient(@RequestBody LinkedHashMap<String, String> param);

    // 查询状态信息
    @RequestMapping(value = "/mediaservice/clients", method = RequestMethod.GET)
    public JSONObject getStatusClients();

    // 查询指定状态信息
    @RequestMapping(value = "/mediaservice/clients/{uuid}", method = RequestMethod.GET)
    public JSONObject getStatusClient(@PathVariable("uuid") String uuid);

    //streams
    //查询流信息
    @RequestMapping(value = "/mediaservice/client/{uuid}/streams", method = RequestMethod.GET)
    public JSONObject getStreams(@PathVariable("uuid") String uuid);

    //查询指定流信息
    @RequestMapping(value = "/mediaservice/client/{uuid}/streams/{name}", method = RequestMethod.GET)
    public JSONObject getStream(@PathVariable("uuid") String uuid, @PathVariable("name") String name);


    //更新流信息
    @RequestMapping(value = "/mediaservice/client/{uuid}/streams", method = RequestMethod.POST)
    public JSONObject updateStreams(@PathVariable("uuid") String uuid, @RequestBody LinkedHashMap<String, String> param);


    //修改流信息
    @RequestMapping(value = "/mediaservice/client/{uuid}/streams", method = RequestMethod.PUT)
    public JSONObject modifyStreams(@PathVariable("uuid") String uuid, @RequestBody LinkedHashMap<String, String> param);


    //删除流信息
    @RequestMapping(value = "/mediaservice/client/{uuid}/streams/{name}", method = RequestMethod.DELETE)
    public JSONObject deleteStream(@PathVariable("uuid") String uuid, @PathVariable("name") String name);


}
