package com.evan.myshop.service.user.api;

import com.evan.myshop.commons.domain.TbUser;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface TbUserService {
    List<TbUser> selectAll();

    PageInfo<TbUser> page(int start, int size);
}
