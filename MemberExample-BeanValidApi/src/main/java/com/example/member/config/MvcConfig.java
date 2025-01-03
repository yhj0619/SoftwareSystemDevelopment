package com.example.member.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.example.member.controller.MemberController;

@Configuration
@EnableWebMvc
@ComponentScan(basePackageClasses={MemberController.class})
public class MvcConfig implements WebMvcConfigurer {

	@Override	// view resolver 설정
	public void configureViewResolvers(ViewResolverRegistry registry) {
		registry.jsp("/WEB-INF/view/", ".jsp");	
	}
	
	@Override	// default servlet 설정
	public void configureDefaultServletHandling(
			DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}
	
	@Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/index").setViewName("index");
    }
    
    @Bean
    public ReloadableResourceBundleMessageSource messageSource() { 
        ReloadableResourceBundleMessageSource source 
            = new ReloadableResourceBundleMessageSource();
        source.setBasename("classpath:messages/validation");
        source.setDefaultEncoding("UTF-8");
        source.setCacheSeconds(60);
        source.setUseCodeAsDefaultMessage(true);        
        return source;
    }
}
