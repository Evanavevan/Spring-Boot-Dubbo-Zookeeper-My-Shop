package com.evan.myshop.api.gateway.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.rpc.RpcContext;
import com.evan.myshop.service.redis.api.RedisConsumerService;
import com.evan.myshop.service.search.api.SearchConsumerServcie;
import com.evan.myshop.service.user.api.UserConsumerService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "router")
public class RouterController {

    @Value(value = "${services.ports.user}")
    private String userPort;

    @Reference(version = "${services.versions.user.v1}")
    private UserConsumerService userConsumerService;

    @Value(value = "${services.ports.search}")
    private String searchPort;

    @Reference(version = "${services.versions.search.v1}")
    private SearchConsumerServcie searchConsumerServcie;

    @Value(value = "${services.ports.redis}")
    private String redisPort;

    @Reference(version = "${services.versions.redis.v1}")
    private RedisConsumerService redisConsumerService;

    @RequestMapping(value = "user", method = RequestMethod.GET)
    public String user(String path) {
        // 远程调用
        userConsumerService.info();

        return getRedirectPath(userPort, path);
    }

    @RequestMapping(value = "search", method = RequestMethod.GET)
    public String search(String path) {
        // 远程调用
        searchConsumerServcie.info();

        return getRedirectPath(userPort, path);
    }

    @RequestMapping(value = "redis", method = RequestMethod.GET)
    public String redis(String path) {
        // 远程调用
        redisConsumerService.info();

        return getRedirectPath(userPort, path);
    }

    /**
     * 获取请求地址
     * @param port  端口
     * @param path  重定向路径
     * @return
     */
    private String getRedirectPath(String port, String path) {
        // 本端是否为消费端，这里会返回false
        boolean consumerSide = RpcContext.getContext().isConsumerSide();
        if (consumerSide) {
            // 获取最后一次调用的提供方IP地址
            String remoteHost = RpcContext.getContext().getRemoteHost();
            return String.format("redirect:http://%s:%s%s", remoteHost, port, path);
        }
        return null;
    }
}
