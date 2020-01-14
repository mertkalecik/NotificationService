package com.example.NotificationService;

import com.example.NotificationService.model.ServerLog;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootApplication
public class NotificationServiceApplication {

	@Bean
	JedisConnectionFactory jedisConnectionFactory() {
		return new JedisConnectionFactory();
	}

	@Bean
	RedisTemplate<String, ServerLog> redisTemplate() {
		RedisTemplate<String, ServerLog> redisTemplate = new RedisTemplate<String, ServerLog>();
		redisTemplate.setConnectionFactory(jedisConnectionFactory());

		return redisTemplate;
	}

	public static void main(String[] args) {
		SpringApplication.run(NotificationServiceApplication.class, args);
	}
}
