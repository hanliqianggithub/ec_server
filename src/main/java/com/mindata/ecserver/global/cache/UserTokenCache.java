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

    public void setBothTokenByUserId(String token, Long userId) {
        stringRedisTemplate.opsForValue().set(keyOfUserId(userId), token, CACHE_USER_HEADER_TOKEN_EXPIE, TimeUnit
                .SECONDS);
        stringRedisTemplate.opsForValue().set(keyOfToken(token), userId + "", CACHE_USER_HEADER_TOKEN_EXPIE, TimeUnit
                .SECONDS);
    }

    public String getTokenByUserId(Long userId) {
        return stringRedisTemplate.opsForValue().get(keyOfUserId(userId));
    }

    public String getUserIdByToken(String token) {
        return stringRedisTemplate.opsForValue().get(keyOfToken(token));
    }

    public void deleteBothByUserId(Long userId) {
        stringRedisTemplate.delete(keyOfUserId(userId));
        stringRedisTemplate.delete(keyOfToken(getTokenByUserId(userId)));
    }

    public Long getExpire(Long userId) {
        return stringRedisTemplate.getExpire(keyOfUserId(userId));
    }

    private String keyOfUserId(Long userId) {
        return CACHE_USER_TOKEN_ID_KEY + "_" + userId;
    }

    private String keyOfToken(String token) {
        return CACHE_USER_TOKEN_KEY + "_" + token;
    }

    public void setBeforeMaxId(Long userId){
        stringRedisTemplate.opsForValue().set(BEFORE_MAX_ID, String.valueOf(userId));
    }

    public void setAfterMaxId(Long userId){
        stringRedisTemplate.opsForValue().set(AFTER_MAX_ID, String.valueOf(userId));
    }

    public String getBeforeMaxId(){
        return stringRedisTemplate.opsForValue().get(BEFORE_MAX_ID);
    }

    public String getAfterMaxId(){
       return stringRedisTemplate.opsForValue().get(AFTER_MAX_ID);
    }
}
