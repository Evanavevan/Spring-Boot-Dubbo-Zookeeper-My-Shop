package com.evan.myshop.api.gateway.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {

    /**
     * 跳转主页
     * @return
     */
    @RequestMapping(value = {"", "main"}, method = RequestMethod.GET)
    public String main() {
        return "main";
    }

    /**
     * 跳转首页
     * @return
     */
    @RequestMapping(value = "index", method = RequestMethod.GET)
    public String index() {
        return "index";
    }

}
