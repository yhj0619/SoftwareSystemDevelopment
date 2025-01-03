package com.example.member.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.example.member.service.MemberService;

@Configuration
@ComponentScan(basePackageClasses={MemberService.class})
public class ApplicationConfig {

}
