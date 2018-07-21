package com.happok.xiyan.mediaclient.service;

import com.alibaba.fastjson.JSONObject;
import com.happok.xiyan.mediaclient.config.SRSClientConfig;
import com.happok.xiyan.mediaclient.entity.RegisterEntity;
import com.happok.xiyan.mediaclient.feignclient.MediaServiceFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.io.*;
import java.util.Timer;
import java.util.TimerTask;
import java.util.UUID;

@Service
public class RegisterService {

    @Autowired
    private SRSClientConfig srsClientConfig = null;
    private RegisterEntity registerEntity = new RegisterEntity();

    @Resource
    private MediaServiceFeign mediaServiceFeign = null;

    private String uuid;

    @PostConstruct
    public void init() {

        writeFile();
        registerEntity.setType(srsClientConfig.getType());
        registerEntity.setHttp_port(srsClientConfig.getHttp_port());
        registerEntity.setServer_ip(srsClientConfig.getIp());
        registerEntity.setRtmp_port(srsClientConfig.getRtmp_port());
        registerEntity.setRtsp_port(srsClientConfig.getRtsp_port());
        registerEntity.setHttp_port(srsClientConfig.getHttp_port());
        registerEntity.setUuid(uuid);
    }

    private boolean IsExistClient() {
        JSONObject result = mediaServiceFeign.getClient(this.uuid);
        if (null != result && null != result.getString("result")) {
            return true;
        }
        return false;
    }

    private void registerClient() {

   /*     try {
            Timer timer = new Timer();//实例化Timer类
            timer.schedule(new TimerTask() {
                public void run() {
                    JSONObject result = mediaServiceFeign.RegeditClient(registerEntity);
                    if (result.getInteger("code").equals("200")) {
                        System.out.printf("success");
                    } else {
                        System.out.printf("failed");
                    }
                    this.cancel();
                }
            }, 5000);//五百毫秒

        } catch (Exception e) {
            System.out.printf("error:" + e.toString());
        }*/
        try {
            JSONObject result = mediaServiceFeign.RegeditClient(registerEntity);
            if (result.getInteger("code").equals("200")) {
                System.out.printf("success");
            } else {
                System.out.printf("failed");
            }
        } catch (Exception e) {
            System.out.printf("error:" + e.toString());
        }
    }

    private boolean writeFile() {

        String path = "key/.uuid";
        File f = new File(path);

        try {

            FileWriter fw = null;
            BufferedWriter bw = null;

            if (!f.exists()) {
                uuid = UUID.randomUUID().toString();
                f.createNewFile();
                fw = new FileWriter(f.getAbsoluteFile());  //true表示可以追加新内容
                bw = new BufferedWriter(fw);
                bw.write(uuid);
                bw.close();
            } else {
                BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(path)));
                String data = null;
                while ((data = br.readLine()) != null) {
                    uuid = data;

                    break;
                }
                return false;
            }

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }


    @Scheduled(cron = "${scheduled.register}")
    public void registerClientTimer() {
        try {
            if (!IsExistClient()) {
                registerClient();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
