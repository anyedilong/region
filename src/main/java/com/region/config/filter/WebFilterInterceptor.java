package com.region.config.filter;


import java.util.List;

import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.codec.Base64;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.region.moudles.common.domain.JsonResult;
import com.region.moudles.common.domain.ProcessStatus;
import com.region.moudles.common.domain.ResponseStatus;
import com.region.moudles.common.utils.cache.UserCache;
import com.region.until.StringUntil;
import com.region.until.cache.CacheEmun;
import com.region.until.cache.CacheUtils;
import com.region.until.sha1.SHA1Encrypt;

@Configuration
public  class WebFilterInterceptor extends WebMvcConfigurerAdapter  {


    @Value("${hispath}")
    private String hispath;
    @Value("${lispath}")
    private String lispath;
    @Value("${healthpath}")
    private String healthpath;
    @Value("${familypath}")
    private String familypath;
    @Value("${restpath}")
    private String restpath;

    //@Inject
   // private SysAuthRepository sysAuthRepository;

    @Override
	public void addCorsMappings(CorsRegistry registry) {
    	registry.addMapping("/**");
	}

    @Bean
	public CorsFilter corsFilter() {
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", buildConfig());
		return new CorsFilter(source);
	}

	private CorsConfiguration buildConfig() {
		CorsConfiguration corsConfiguration = new CorsConfiguration();
		corsConfiguration.addAllowedOrigin("*");
		corsConfiguration.addAllowedHeader("*");
		corsConfiguration.addAllowedMethod("*");
		return corsConfiguration;
	}

	@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		//调用父类的配置
        super.configureMessageConverters(converters);
        //创建fastJson消息转换器
        FastJsonHttpMessageConverter fastConverter = new FastJsonHttpMessageConverter();
        //创建配置类
        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        //修改配置返回内容的过滤
        fastJsonConfig.setSerializerFeatures(
                SerializerFeature.DisableCircularReferenceDetect,
                SerializerFeature.WriteMapNullValue,
                SerializerFeature.WriteNullStringAsEmpty
        );
        fastConverter.setFastJsonConfig(fastJsonConfig);
        //将fastjson添加到视图消息转换器列表内
        converters.add(fastConverter);
	}
    
    @Override
    public void addInterceptors(InterceptorRegistry registry){
        /**
         * his系统过滤
         */
        registry.addInterceptor(new HandlerInterceptorAdapter() {
            @Override
            public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
                
				/*
				 * String auth_code = request.getHeader("auth_code"); String
				 * id=sysAuthRepository.queryAuth(auth_code); if(StringUntil.isNull(id)){ }
				 */
                 return true;

            }
        }).addPathPatterns(String.format("%s/**",hispath));
        /**
         * lis系统
         */
        registry.addInterceptor(new HandlerInterceptorAdapter() {
            @Override
            public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
                return true;
            }
        }).addPathPatterns(String.format("%s/**",lispath));
        /**
         * 	公卫系统
         */
        registry.addInterceptor(new HandlerInterceptorAdapter() {
            @Override
            public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
                return true;
            }
        }).addPathPatterns(String.format("%s/**",healthpath));
        /**
         * 	家医系统
         */
        registry.addInterceptor(new HandlerInterceptorAdapter() {
            @Override
            public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
                return  true;
            }
        }).addPathPatterns(String.format("%s/**",familypath));
        /**
         * 	平台验证
         */
        registry.addInterceptor(new HandlerInterceptorAdapter() {
            @Override
            public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
            	
            	//大屏统计数据获取
        		if(request.getRequestURL().toString().contains("/stats")) {
            		return true;
            	}
				// 客户端请求的授权码
				String authorToken = StatelessParams.getSecurityToken(request);
				if (StringUntil.isNull(authorToken)) {
					// 身份认证错误
					onAuthFail(response);
					return false;
				}
				//获得加密后的储存securityToken的key
				String uuid = Base64.encodeToString(authorToken.getBytes());
				String cacheToken = CacheUtils.get(CacheEmun.SYS_CACHE, uuid, String.class);
				if(!authorToken.equals(cacheToken)) {
					// 身份认证错误
					onAuthFail(response);
					return false;
				}
				
				// 验证缓存中是否存在该用户信息
				String key = SHA1Encrypt.encryptToken(authorToken);
				UserCache userCache = CacheUtils.get(CacheEmun.USER_CACHE, key, UserCache.class);

				if (null == userCache || StringUntil.isNull(userCache.getUserId())) {
					// 身份认证错误
					onAuthFail(response);
					return false;
				}
				
                return true;
            }
        }).addPathPatterns(String.format("%s/**",familypath))
		.excludePathPatterns("/family/org/getChildOrg");
    }

    /**
	 * 
	 * <li>描述:身份认证错误默认返回401状态码</li>
	 * <li>方法名称:onAuthFail</li>
	 * <li>参数:@param response
	 * <li>参数:@throws Exception</li>
	 * <li>返回类型:void</li>
	 * <li>最后更新作者:gaoqs</li>
	 */
	private void onAuthFail(ServletResponse response) throws Exception {
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		response.setContentType("application/json;charset=UTF-8");
		JsonResult ret = new JsonResult("身份认证错误", ProcessStatus.AUTH_ERROR);
		ret.setResponseStatus(ResponseStatus.HTTP_UNAUTHORIZED);
	//	httpResponse.getWriter().write(ret.toJsonString());
		httpResponse.getWriter().flush();
		httpResponse.getWriter().close();
	}
	
}
