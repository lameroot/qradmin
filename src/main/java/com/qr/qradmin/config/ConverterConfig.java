package com.qr.qradmin.config;

import com.qr.qradmin.converter.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.ConversionService;
import org.springframework.format.support.FormattingConversionService;

@Configuration
public class ConverterConfig {

    @Bean
    public ConversionService conversionService() {
        FormattingConversionService formattingConversionService = new FormattingConversionService();
        formattingConversionService.addConverter(new StringToSortConverter());
        formattingConversionService.addConverter(new StringToFilterConverter());
        formattingConversionService.addConverter(new UserInfoToDtoConverter());
        formattingConversionService.addConverter(new UserToDtoConverter());
        formattingConversionService.addConverter(userToEntityConverter());
        formattingConversionService.addConverter(new MerchantOrderToDtoConverter());
        formattingConversionService.addConverter(new OrderTemplateToDtoConverter());
        formattingConversionService.addConverter(orderTemplateToEntityConverter());
        formattingConversionService.addConverter(new MerchantToDtoConverter());
        formattingConversionService.addConverter(new MerchantToEntityConverter());
        formattingConversionService.addConverter(new TerminalToDtoConverter());
        formattingConversionService.addConverter(terminalToEntityConverter());

        return formattingConversionService;
    }

    @Bean
    public UserToEntityConverter userToEntityConverter() {
        return new UserToEntityConverter();
    }
    @Bean
    public TerminalToEntityConverter terminalToEntityConverter() {
        return new TerminalToEntityConverter();
    }
    @Bean
    public OrderTemplateToEntityConverter orderTemplateToEntityConverter() {
        return new OrderTemplateToEntityConverter();
    }
}
