package com.ecommerce.config;

import javax.servlet.ServletContext;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.ecommerce.service.IUserService;



public class SpringUtil {
//	static ApplicationContext appContext =  new ClassPathXmlApplicationContext("/src/main/resources/spring/config/BeanLocations.xml");
	private static IUserService userService;
	
	public static IUserService getUserService(ServletContext servletContext){
		if(userService == null){
			WebApplicationContext ctx = WebApplicationContextUtils.getRequiredWebApplicationContext(servletContext);
			userService = (IUserService) ctx.getBean("userService");			
		}
		return userService;
	}
	
//	
//	public static void main(String[] args){
//		appContext =  new ClassPathXmlApplicationContext("/src/main/resources/spring/config/BeanLocations.xml");
//		HombreBo bo = (HombreBo) appContext.getBean("stockBo");
//	}
}
