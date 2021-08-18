package com.example.springboothelloworld;

import com.example.springboothelloworld.servlet.HelloFilter;
import com.example.springboothelloworld.servlet.HelloListener;
import com.example.springboothelloworld.servlet.HelloServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
//@ServletComponentScan
public class SpringBootHelloworldApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootHelloworldApplication.class, args);
	}

	//Servlet Registration
	@Bean
	public ServletRegistrationBean getServletRegistrationBean(){
		ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new HelloServlet());
		servletRegistrationBean.addUrlMappings("/helloServlet");
		return servletRegistrationBean;
	}

	//Filter Registration
	@Bean
	public FilterRegistrationBean getFilterRegistrationBean(){
		FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(new HelloFilter());
		filterRegistrationBean.addUrlPatterns("/helloServlet");
		return  filterRegistrationBean;
	}

	@Bean
	public ServletListenerRegistrationBean<HelloListener> getListenerRegistrationBean(){
		ServletListenerRegistrationBean servletListenerRegistrationBean = new ServletListenerRegistrationBean(new HelloListener());
		return  servletListenerRegistrationBean;
	}




}
