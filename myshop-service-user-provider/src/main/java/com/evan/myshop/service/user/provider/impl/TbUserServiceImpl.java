package com.evan.myshop.service.user.provider.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.evan.myshop.commons.domain.TbUser;
import com.evan.myshop.commons.mapper.TbUserMapper;
import com.evan.myshop.service.user.api.TbUserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service(version = "${services.versions.user.v1}")
@Transactional(readOnly = true)
public class TbUserServiceImpl implements TbUserService {

    @Autowired
    private TbUserMapper tbUserMapper;

    @Override
    public List<TbUser> selectAll() {
        return tbUserMapper.selectAll();
    }

    @Override
    public PageInfo<TbUser> page(int start, int size) {
        Example example = new Example(TbUser.class);
        PageHelper.offsetPage(start, size);
        PageInfo<TbUser> tbUserPageInfo = new PageInfo<>(tbUserMapper.selectByExample(example));
        return tbUserPageInfo;
    }
}
