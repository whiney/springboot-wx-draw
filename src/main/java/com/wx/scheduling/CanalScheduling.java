package com.wx.scheduling;

import com.wx.utils.PictureUtil;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class CanalScheduling implements Runnable, ApplicationContextAware {

    private ApplicationContext applicationContext;

    @Scheduled(cron =  "0 0 1 ? * *")
    @Override
    public void run() {
        String root=System.getProperty("user.dir");//项目根目录路径
        String outPath = root + "/static/data/";
        PictureUtil.deleteDirectory(outPath);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }


}
