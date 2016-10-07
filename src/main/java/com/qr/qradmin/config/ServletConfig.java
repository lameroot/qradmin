package com.qr.qradmin.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qr.qradmin.converter.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
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
public class ServletConfig extends WebMvcConfigurerAdapter {

    @Resource
    private Environment environment;

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapper();
    }

    @Bean
    public CommonsMultipartResolver multipartResolver() {
        return new CommonsMultipartResolver();
    }

    @Bean
    public MappingJackson2HttpMessageConverter jacksonMessageConverter() {
        return new MappingJackson2HttpMessageConverter(objectMapper());
    }

    @Bean
    public ConversionService conversionService() {
        FormattingConversionService formattingConversionService = new FormattingConversionService();
        formattingConversionService.addConverter(new StringToSortConverter());
        formattingConversionService.addConverter(new StringToFilterConverter());
        formattingConversionService.addConverter(new UserInfoToDtoConverter());
        formattingConversionService.addConverter(new UserToDtoConverter());
        formattingConversionService.addConverter(new UserToEntityConverter());
        formattingConversionService.addConverter(new MerchantOrderToDtoConverter());
        formattingConversionService.addConverter(new OrderTemplateToDtoConverter());
        formattingConversionService.addConverter(new OrderTemplateToEntityConverter());

        return formattingConversionService;
    }

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(jacksonMessageConverter());
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //registry.addResourceHandler("/**").addResourceLocations(environment.getProperty("application.static.path"));
    }
}
