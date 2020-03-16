package com.wx.pojo;

/**
 * Created by baishuai on 2019/1/30
 */
public class FontText {

    private String text;

    private int wm_text_pos;

    private String wm_text_color;

    private Integer wm_text_size;

    private String wm_text_font;//字体  “黑体，Arial”

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getWm_text_pos() {
        return wm_text_pos;
    }

    public void setWm_text_pos(int wm_text_pos) {
        this.wm_text_pos = wm_text_pos;
    }

    public String getWm_text_color() {
        return wm_text_color;
    }

    public void setWm_text_color(String wm_text_color) {
        this.wm_text_color = wm_text_color;
    }

    public Integer getWm_text_size() {
        return wm_text_size;
    }

    public void setWm_text_size(Integer wm_text_size) {
        this.wm_text_size = wm_text_size;
    }

    public String getWm_text_font() {
        return wm_text_font;
    }

    public void setWm_text_font(String wm_text_font) {
        this.wm_text_font = wm_text_font;
    }

    public FontText(String text, int wm_text_pos, String wm_text_color,
                    Integer wm_text_size, String wm_text_font) {
        super();
        this.text = text;
        this.wm_text_pos = wm_text_pos;
        this.wm_text_color = wm_text_color;
        this.wm_text_size = wm_text_size;
        this.wm_text_font = wm_text_font;
    }

    public FontText(){}

}
