package com.qr.qradmin.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@ComponentScan(value = "com.qr.qradmin.security")
@ImportResource(value = "classpath:config/spring/security.xml")
@EnableWebSecurity
public class SecurityConfig  extends WebSecurityConfigurerAdapter {

}
