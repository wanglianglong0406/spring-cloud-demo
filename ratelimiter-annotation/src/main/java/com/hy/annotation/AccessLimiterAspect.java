package com.hy.annotation;

import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.script.RedisScript;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * @author 寒夜
 */
@Slf4j
@Aspect
@Component
public class AccessLimiterAspect {

    private final StringRedisTemplate stringRedisTemplate;

    private final RedisScript<Boolean> rateLimitLua;

    public AccessLimiterAspect(StringRedisTemplate stringRedisTemplate, RedisScript<Boolean> rateLimitLua) {
        this.stringRedisTemplate = stringRedisTemplate;
        this.rateLimitLua = rateLimitLua;
    }



    @Pointcut(value = "@annotation(com.hy.annotation.AccessLimiter)")
    public void cut() {
        log.info("cut");
    }

    @Before("cut()")
    public void before(JoinPoint joinPoint) {
        // 1. 获得方法签名，作为method Key
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();

        AccessLimiter annotation = method.getAnnotation(AccessLimiter.class);
        if (annotation == null) {
            return;
        }

        String key = annotation.methodKey();
        int limit = annotation.limit();

        // 如果没设置methodkey, 从调用方法签名生成自动一个key
        if (StringUtils.isEmpty(key)) {
            Class[] type = method.getParameterTypes();
            key = method.getClass() + method.getName();

            if (type != null) {
                String paramTypes = Arrays.stream(type)
                        .map(Class::getName)
                        .collect(Collectors.joining(","));
                log.info("param types: " + paramTypes);
                key += "#" + paramTypes;
            }
        }

        // 2. 调用Redis
        boolean acquired = stringRedisTemplate.execute(
                rateLimitLua, // Lua script的真身
                Lists.newArrayList(key), // Lua脚本中的Key列表
                Integer.toString(limit) // Lua脚本Value列表
        );

        if (!acquired) {
            log.error("your access is blocked, key={}", key);
            throw new RuntimeException("Your access is blocked");
        }
    }

}
