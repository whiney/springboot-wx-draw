package com.wx.utils;

import java.awt.*;
import java.io.File;
import java.io.FileInputStream;

/**
 * Created by baishuai on 2019/1/30
 */
public class Loadfont {

    public static Font loadFont(String fontFileName, float fontSize)  //第一个参数是外部字体名，第二个是字体大小

    {

        try

        {

            File file = new File(fontFileName);

            FileInputStream aixing = new FileInputStream(file);

            Font dynamicFont = Font.createFont(Font.TRUETYPE_FONT, aixing);

            Font dynamicFontPt = dynamicFont.deriveFont(fontSize);

            aixing.close();

            return dynamicFontPt;

        }

        catch(Exception e)//异常处理

        {

            e.printStackTrace();

            return new java.awt.Font("宋体", Font.PLAIN, 14);

        }

    }

}
