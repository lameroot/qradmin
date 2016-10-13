package com.qr.qradmin.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qr.qradmin.converter.*;
import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.core.env.Environment;
import org.springframework.format.support.FormattingConversionService;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Configuration
@EnableWebMvc
@ComponentScan(value = {"com.qr.qradmin.controller","com.qr.qradmin.generic"})
public class ServletConfig extends WebMvcConfigurerAdapter {

    @Resource
    private Environment environment;
    @Resource
    private MappingJackson2HttpMessageConverter jacksonMessageConverter;

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Bean
    public CommonsMultipartResolver multipartResolver() {
        return new CommonsMultipartResolver();
    }


    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(jacksonMessageConverter);
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**").addResourceLocations(environment.getProperty("application.static.path"));
    }

}
