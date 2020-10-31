package com.hy;

import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.script.RedisScript;
import org.springframework.stereotype.Service;

/**
 * Created by 半仙.
 */
@Service
@Slf4j
@Deprecated
public class AccessLimiter {

    private final StringRedisTemplate stringRedisTemplate;

    private final RedisScript<Boolean> rateLimitLua;

    public AccessLimiter(StringRedisTemplate stringRedisTemplate, RedisScript<Boolean> rateLimitLua) {
        this.stringRedisTemplate = stringRedisTemplate;
        this.rateLimitLua = rateLimitLua;
    }

    public void limitAccess(String key, Integer limit) {
        // step 1 : request Lua script
        boolean acquired = stringRedisTemplate.execute(
                rateLimitLua, // Lua script的真身
                Lists.newArrayList(key), // Lua脚本中的Key列表
                limit.toString() // Lua脚本Value列表
        );

        if (!acquired) {
            log.error("your access is blocked, key={}", key);
            throw new RuntimeException("Your access is blocked");
        }
    }

}
