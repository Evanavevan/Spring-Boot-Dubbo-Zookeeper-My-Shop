package com.evan.myshop.service.user.api;

import com.evan.myshop.commons.domain.TbUser;

import java.util.List;

public interface TbUserService {
    List<TbUser> selectAll();
}
