package com.region;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Service;

import com.region.config.spring.InstanceFactory;
import com.region.moudles.system.service.InitService;

import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.MultipartConfigElement;

@ComponentScan(basePackages = {"com.region"},includeFilters = {
		@ComponentScan.Filter(value = Service.class, type = FilterType.ANNOTATION),
		@ComponentScan.Filter(value = Named.class, type = FilterType.ANNOTATION),
		@ComponentScan.Filter(value = Inject.class, type = FilterType.ANNOTATION)})
@Configuration
@EnableAutoConfiguration
public class RegionApplication {

	public static void main(String[] args) {
		SpringApplication application = new SpringApplication(RegionApplication.class);
		application.setWebEnvironment(true);
		ApplicationContext context = application.run();
		InstanceFactory instanceFactory = new InstanceFactory();
		instanceFactory.setApplicationContext(context);
		InstanceFactory.getbean(InitService.class).InitData();
	}

	/**
     * 	文件上传配置  
     * @return  
     */  
    @Bean  
    public MultipartConfigElement multipartConfigElement() {  
        MultipartConfigFactory factory = new MultipartConfigFactory();  
        //单个文件最大  
        factory.setMaxFileSize("10240MB"); //KB,MB  
        //设置总上传数据总大小  
        factory.setMaxRequestSize("102400MB");
        return factory.createMultipartConfig();
    }
}
