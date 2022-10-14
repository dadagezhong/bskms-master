/*
 * All rights Reserved, Copyright (C) Aisino LIMITED 2018
 * FileName: WebConfig.java
 * Version:  $Revision$
 * Modify record:
 * NO. |     Date       |    Name         |      Content
 * 1   | 2019年1月2日        | Aisino)Jack    | original version
 */
package com.bskms.config;

import java.nio.charset.Charset;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.bskms.common.MyDateFormat;
import com.bskms.filter.TimeFilter;
import com.bskms.interceptor.ProcessInterceptor;
import com.bskms.listener.ListenerTest;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * class name:WebConfig <BR>
 * class description: 全局配置文件 <BR>
 * Remark: <BR>
 * 
 * @version 1.00 2019年1月2日
 * @author Aisino)weihaohao
 */
@Configuration
public class WebConfig implements WebMvcConfigurer{
	
	 @Override
	 public void addInterceptors(InterceptorRegistry registry) {
	        registry.addInterceptor(new ProcessInterceptor()); 
	 }
	/**
	 * Method name: timeFilter <BR>
	 * Description: 配置过滤器 <BR>
	 * Remark: <BR>
	 * 
	 * @return FilterRegistrationBean<BR>
	 */
	@Bean
	public FilterRegistrationBean<TimeFilter> timeFilter() {
		FilterRegistrationBean<TimeFilter> registrationBean = new FilterRegistrationBean<TimeFilter>();
		TimeFilter timeFilter = new TimeFilter();
		registrationBean.setFilter(timeFilter);

		List<String> urls = new ArrayList<>();
		urls.add("/*");
		registrationBean.setUrlPatterns(urls);

		return registrationBean;
	}

	/**
	 * 
	 * Method name: servletListenerRegistrationBean <BR>
	 * Description: 配置监听器<BR>
	 * Remark: <BR>
	 * 
	 * @return ServletListenerRegistrationBean<ListenerTest><BR>
	 */
	@Bean
	public ServletListenerRegistrationBean<ListenerTest> servletListenerRegistrationBean() {
		return new ServletListenerRegistrationBean<ListenerTest>(new ListenerTest());
	}

	@Autowired
	private Jackson2ObjectMapperBuilder jackson2ObjectMapperBuilder;

	@Bean
	public MappingJackson2HttpMessageConverter MappingJsonpHttpMessageConverter() {

		ObjectMapper mapper = jackson2ObjectMapperBuilder.build();

		// ObjectMapper为了保障线程安全性，里面的配置类都是一个不可变的对象
		// 所以这里的setDateFormat的内部原理其实是创建了一个新的配置类
		DateFormat dateFormat = mapper.getDateFormat();
		mapper.setDateFormat(new MyDateFormat(dateFormat));

		TimeZone tz = TimeZone.getDefault();
		@SuppressWarnings("static-access")
		TimeZone Shanghai = tz.getTimeZone("Asia/Shanghai");
		dateFormat.setTimeZone(Shanghai);

		MappingJackson2HttpMessageConverter mappingJsonpHttpMessageConverter = new MappingJackson2HttpMessageConverter(
				mapper);
		return mappingJsonpHttpMessageConverter;
	}
}
