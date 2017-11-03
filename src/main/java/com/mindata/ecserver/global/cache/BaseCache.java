package com.mindata.ecserver.global.cache;

import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author wuweifeng wrote on 2017/11/3.
 */
@Component
public class BaseCache {
    @Resource
    protected StringRedisTemplate stringRedisTemplate;
}
