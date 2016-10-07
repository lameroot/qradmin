package com.qr.qradmin.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource(value = "classpath:config/spring/security.xml")
public class SecurityConfig  {

}
