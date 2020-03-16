package com.wx.init;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.wx.thread.AccessTokenThread;
import com.wx.thread.JsApiTicketThread;

/**
 * 容器启动就会运行这个类，获取access_token和jsp_ticket
 */
@Component
public class InitParameters implements ApplicationRunner{

    @Value("${WX_APPID}")
    private String WX_APPID;
    @Value("${WX_APPSECRET}")
    private String WX_APPSECRET;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        AccessTokenThread.appid = WX_APPID;
        AccessTokenThread.appsecret = WX_APPSECRET;

        if ("".equals(AccessTokenThread.appid) || "".equals(AccessTokenThread.appsecret)) {
            System.out.println("appid和appsecret未给出");
        } else {
            new Thread(new AccessTokenThread()).start();
            new Thread(new JsApiTicketThread()).start();
        }
    }
}
