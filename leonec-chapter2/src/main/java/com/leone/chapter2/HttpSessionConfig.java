package com.leone.chapter2;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 * @author oldflame-jm
 * @create 2018/1/12
 * ${DESCRIPTION}
 */


@Configuration
@EnableRedisHttpSession
public class HttpSessionConfig {

	@Bean
	public JedisConnectionFactory connectionFactory() {
		return new JedisConnectionFactory();
	}
}
