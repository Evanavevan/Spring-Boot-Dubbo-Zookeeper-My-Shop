package com.evan.myshop.service.redis.consumer.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.evan.myshop.commons.domain.TbUser;
import com.evan.myshop.service.user.api.TbUserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping(value = "user")
public class TbUserController {

    @Reference(version = "${services.versions.redis.v1}")
    private TbUserService tbUserService;

    @RequestMapping(value = "list", method = RequestMethod.GET)
    public String list(Model model) {
        List<TbUser> tbUsers = tbUserService.selectAll();
        model.addAttribute("tbUsers", tbUsers);
        return "user/list";
    }
}