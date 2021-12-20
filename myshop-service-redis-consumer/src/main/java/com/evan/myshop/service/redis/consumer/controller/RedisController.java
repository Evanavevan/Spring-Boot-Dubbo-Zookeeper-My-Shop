package com.evan.myshop.service.redis.consumer.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.evan.myshop.service.redis.api.RedisService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "redis")
public class RedisController {

    @Reference(version = "${services.versions.redis.v1}")
    private RedisService redisService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Object get(@PathVariable("id") String Id) {
        return redisService.get(Id);
    }

    @RequestMapping(value = "/set", method = RequestMethod.POST)
    public void set(@RequestParam("key") String key, @RequestParam("value") String value, @RequestParam(required = false) Integer second) {
        if (second != 0) {
            redisService.set(key, value, second);
        }
        redisService.set(key, value);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public void delete(@PathVariable("id") String Id) {
        redisService.delete(Id);
    }
}
