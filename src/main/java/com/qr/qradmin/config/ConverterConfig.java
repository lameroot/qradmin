package com.qr.qradmin.config;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.format.support.FormattingConversionService;

import javax.annotation.Resource;
import java.util.Map;

@ComponentScan(value = {"com.qr.qradmin.converter"})
@Configuration
public class ConverterConfig {

    @Resource
    private ApplicationContext applicationContext;

    @Bean
    public ConversionService conversionService() {
        FormattingConversionService formattingConversionService = new FormattingConversionService();
        for (Map.Entry<String, Converter> entry : applicationContext.getBeansOfType(Converter.class).entrySet()) {
            formattingConversionService.addConverter(entry.getValue());
        }
        return formattingConversionService;
    }

}
