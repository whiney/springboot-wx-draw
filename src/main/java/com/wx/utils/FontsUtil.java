package com.wx.utils;


import java.awt.*;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by baishuai on 2019/1/24
 */
public class FontsUtil {

    /**
     * 宋体
     * @param style
     * @param size
     */
    public static Font getSIMSUN(int style, float size) {
        Font font = null;
        //获取字体流
        InputStream simsunFontFile = FontsUtil.class.getResourceAsStream("/fonts/juzhen.ttf");
        try {
            //创建字体
            font = Font.createFont(Font.PLAIN, simsunFontFile).deriveFont(style, size);
        } catch (FontFormatException e) {
            System.out.println(e);
        } catch (IOException e) {
            font = new Font("宋体", Font.BOLD, 6);
            System.out.println(e);
        }
        return font;
    }

    public static void main(String[] args) {
        System.out.println(getSIMSUN(1, 50));
    }

}
