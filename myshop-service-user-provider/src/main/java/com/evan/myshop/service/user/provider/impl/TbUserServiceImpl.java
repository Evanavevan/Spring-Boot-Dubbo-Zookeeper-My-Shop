package com.evan.myshop.service.user.provider.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.evan.myshop.commons.domain.TbUser;
import com.evan.myshop.service.user.api.TbUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service(version = "${services.versions.redis.v1}")
@Transactional(readOnly = true)
public class TbUserServiceImpl implements TbUserService {

    @Autowired
    private TbUserService tbUserService;

    @Override
    public List<TbUser> selectAll() {
        return tbUserService.selectAll();
    }
}
