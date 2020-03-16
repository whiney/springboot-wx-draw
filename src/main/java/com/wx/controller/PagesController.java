package com.wx.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PagesController {

    @ResponseBody
    @RequestMapping(value="/", method = RequestMethod.GET)
    public ModelAndView index() {
        return new ModelAndView("index");
    }

    @ResponseBody
    @RequestMapping(value="/pc", method = RequestMethod.GET)
    public ModelAndView pc() {
        return new ModelAndView("pc");
    }

}
