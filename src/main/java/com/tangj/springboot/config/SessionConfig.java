package com.tangj.springboot.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 * Session配置,将session信息存储在redis,实现分布式session共享
 * @author THINK
 * 
 * maxInactiveIntervalInSeconds: 设置Session失效时间，使用Redis
 * Session之后，原Boot的server.session.timeout属性不再生效
 *
 */
@Configuration
@EnableRedisHttpSession(maxInactiveIntervalInSeconds = 86400 * 30)
public class SessionConfig {

}