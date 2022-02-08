package com.evan.myshop.commons.mapper;

import com.evan.myshop.commons.domain.TbOrderShipping;
import com.evan.myshop.commons.utils.RedisCache;
import org.apache.ibatis.annotations.CacheNamespace;
import tk.mybatis.mapper.MyMapper;

// 二级缓存
@CacheNamespace(implementation = RedisCache.class)
public interface TbOrderShippingMapper extends MyMapper<TbOrderShipping> {
}