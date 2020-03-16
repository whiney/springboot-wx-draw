package com.wx.controller;

import com.wx.utils.PictureUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.io.IOException;
import java.util.UUID;

@Controller
public class PicController {

	@RequestMapping("/createPic")
    public @ResponseBody String createPic(String name, String title) throws IOException {

        String path = System.getProperty("user.dir");
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        String filePath = path+ "/static/imgs/background2.png";
        String outPath = path+ "/static/data/" +uuid+".png";
        PictureUtil.drawTextInImg(filePath, outPath, name, title);
	    return uuid;
    }
}
