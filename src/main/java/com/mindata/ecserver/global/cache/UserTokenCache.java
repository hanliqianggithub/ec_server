package com.mindata.ecserver.global.cache;

import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

import static com.mindata.ecserver.global.constant.CacheConstant.*;

/**
 * @author wuweifeng wrote on 2017/10/30.
 * 用户登录token的缓存管理
 */
@Component
public class UserTokenCache extends BaseCache {

    public void setBothTokenByUserId(String token, Integer userId) {
        stringRedisTemplate.opsForValue().set(keyOfUserId(userId), token, CACHE_USER_HEADER_TOKEN_EXPIE, TimeUnit
                .SECONDS);
        stringRedisTemplate.opsForValue().set(keyOfToken(token), userId + "", CACHE_USER_HEADER_TOKEN_EXPIE, TimeUnit
                .SECONDS);
    }

    public String getTokenByUserId(Integer userId) {
        return stringRedisTemplate.opsForValue().get(keyOfUserId(userId));
    }

    public String getUserIdByToken(String token) {
        return stringRedisTemplate.opsForValue().get(keyOfToken(token));
    }

    public void deleteBothByUserId(Integer userId) {
        stringRedisTemplate.delete(keyOfUserId(userId));
        stringRedisTemplate.delete(keyOfToken(getTokenByUserId(userId)));
    }

    public Long getExpire(Integer userId) {
        return stringRedisTemplate.getExpire(keyOfUserId(userId));
    }

    private String keyOfUserId(Integer userId) {
        return CACHE_USER_TOKEN_ID_KEY + "_" + userId;
    }

    private String keyOfToken(String token) {
        return CACHE_USER_TOKEN_KEY + "_" + token;
    }
}
