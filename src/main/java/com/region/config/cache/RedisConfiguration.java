/**
 * 
 */
package com.region.config.cache;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

import redis.clients.jedis.JedisPoolConfig;

/**
 * 
 * @ClassName CacheConfiguration
 * @Description ehCache 默认缓存配置
 * @author sen
 * @Date 2016年11月20日 上午9:36:47
 * @version 1.0.0
 */
@Configuration
public class RedisConfiguration {

	@Value("${spring.redis.host}")
	private String host;

	@Value("${spring.redis.port}")
	private int port;

	@Value("${spring.redis.password}")
	private String password;

	// redis连接池配置
	@Bean(name = "poolConfig")
	public JedisPoolConfig poolConfig() {
		JedisPoolConfig poolConfig = new JedisPoolConfig();
		/* 最大连接数 */
		poolConfig.setMaxTotal(30);
		/* 最大空闲连接数 */
		poolConfig.setMaxIdle(10);
		poolConfig.setMinIdle(8);//设置最小空闲数
		/* 每次释放连接的最大数目 */
		poolConfig.setNumTestsPerEvictionRun(1024);
		/* 释放连接的扫描间隔（毫秒） */
		poolConfig.setTimeBetweenEvictionRunsMillis(3000);
		/* 连接最小空闲时间 */
		poolConfig.setMinEvictableIdleTimeMillis(1800000);
		/* 连接空闲多久后释放, 当空闲时间>该值 且 空闲连接>最大空闲连接数 时直接释放 */
		poolConfig.setSoftMinEvictableIdleTimeMillis(1000);
		/* 获取连接时的最大等待毫秒数,小于零:阻塞不确定的时间,默认-1 */
		poolConfig.setMaxWaitMillis(1500);
		/* 在获取连接的时候检查有效性, 默认false */
		poolConfig.setTestOnBorrow(true);
		/* 在空闲时检查有效性, 默认false */
		poolConfig.setTestWhileIdle(true);
		/* 连接耗尽时是否阻塞, false报异常,ture阻塞直到超时, 默认true */
		poolConfig.setBlockWhenExhausted(false);

		return poolConfig;
	}

	@Bean(name = "jsonRedisSerializer")
	public JsonRedisSerializer jsonRedisSerializer() {
		JsonRedisSerializer jsonRedisSerializer = new JsonRedisSerializer();
		return jsonRedisSerializer;
	}

	@Bean(name = "cacheRedisTemplate")
	@DependsOn({ "jsonRedisSerializer", "poolConfig" })
	public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory factory, JedisPoolConfig poolConfig,
			JsonRedisSerializer jsonRedisSerializer) {

		// 获取工厂
		JedisConnectionFactory connectionFactory = getConnectionFactory();
		connectionFactory.setPoolConfig(poolConfig);
		connectionFactory.setDatabase(1);
		connectionFactory.afterPropertiesSet();

		final RedisTemplate<String, Object> template = new RedisTemplate<>();
		template.setConnectionFactory(connectionFactory);

		template.setKeySerializer(jsonRedisSerializer);
		template.setValueSerializer(jsonRedisSerializer);
		template.setHashKeySerializer(jsonRedisSerializer);
		template.setHashValueSerializer(jsonRedisSerializer);

		return template;
	}

	/**
	 * @Description 系统缓存
	 * @author sen
	 * @Date 2016年11月21日 上午11:00:38
	 */
	@Bean(name = "sysRedisTemplate")
	@DependsOn({ "jsonRedisSerializer", "poolConfig" })
	public RedisTemplate<String, Object> sysRedisTemplate(RedisConnectionFactory factory, JedisPoolConfig poolConfig,
			JsonRedisSerializer jsonRedisSerializer) {
		// 获取工厂
		JedisConnectionFactory connectionFactory = getConnectionFactory();
		connectionFactory.setPoolConfig(poolConfig);
		connectionFactory.setDatabase(2);
		connectionFactory.afterPropertiesSet();

		final RedisTemplate<String, Object> template = new RedisTemplate<>();
		template.setConnectionFactory(connectionFactory);

		template.setKeySerializer(jsonRedisSerializer);
		template.setValueSerializer(jsonRedisSerializer);
		template.setHashKeySerializer(jsonRedisSerializer);
		template.setHashValueSerializer(jsonRedisSerializer);

		return template;
	}

	/**
	 * @Description 用户缓存
	 * @author sen
	 * @Date 2016年11月21日 上午11:00:38
	 */
	@Bean(name = "userRedisTemplate")
	@DependsOn({ "jsonRedisSerializer", "poolConfig" })
	public RedisTemplate<String, Object> userRedisTemplate(RedisConnectionFactory factory, JedisPoolConfig poolConfig,
			JsonRedisSerializer jsonRedisSerializer) {

		// 获取工厂
		JedisConnectionFactory connectionFactory = getConnectionFactory();
		connectionFactory.setPoolConfig(poolConfig);
		connectionFactory.setDatabase(3);
		connectionFactory.afterPropertiesSet();

		final RedisTemplate<String, Object> template = new RedisTemplate<>();
		template.setConnectionFactory(connectionFactory);

		template.setKeySerializer(jsonRedisSerializer);
		template.setValueSerializer(jsonRedisSerializer);
		template.setHashKeySerializer(jsonRedisSerializer);
		template.setHashValueSerializer(jsonRedisSerializer);

		return template;
	}

	/**
	 * @Description 验证数据缓存
	 * @author sen
	 * @Date 2016年11月21日 上午11:00:38
	 */
	@Bean(name = "dsRedisTemplate")
	@DependsOn({ "jsonRedisSerializer", "poolConfig" })
	public RedisTemplate<String, Object> dsRedisTemplate(RedisConnectionFactory factory, JedisPoolConfig poolConfig,
			JsonRedisSerializer jsonRedisSerializer) {

		// 获取工厂
		JedisConnectionFactory connectionFactory = getConnectionFactory();
		connectionFactory.setPoolConfig(poolConfig);
		connectionFactory.setDatabase(10);
		connectionFactory.afterPropertiesSet();

		final RedisTemplate<String, Object> template = new RedisTemplate<>();
		template.setConnectionFactory(connectionFactory);

		template.setKeySerializer(jsonRedisSerializer);
		template.setValueSerializer(jsonRedisSerializer);
		template.setHashKeySerializer(jsonRedisSerializer);
		template.setHashValueSerializer(jsonRedisSerializer);

		return template;
	}

	/** redis连接工厂 */
	private JedisConnectionFactory getConnectionFactory() {
		JedisConnectionFactory connectionFactory = new JedisConnectionFactory();

		// connectionFactory.setPassword(password);
		connectionFactory.setHostName(host);
		connectionFactory.setPort(port);
		connectionFactory.setTimeout(3000);

		return connectionFactory;
	}

}
