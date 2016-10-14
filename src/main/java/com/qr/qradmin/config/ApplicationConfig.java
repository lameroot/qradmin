package com.qr.qradmin.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qr.qradmin.converter.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.convert.ConversionService;
import org.springframework.format.support.FormattingConversionService;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan(value = {"com.qr.qradmin.converter","com.qr.qradmin.service","com.qr.qradmin.validator"})
@PropertySource(ignoreResourceNotFound = true,
        value = {
                "classpath:config/properties/application.properties",
                "${" + ApplicationConfig.SYSTEM_VARIABLE_CONFIG_LOCATION + "}"
        })
@EnableScheduling
@Import(value = {
        DatasourceConfig.class,
        SecurityConfig.class
})
public class ApplicationConfig {

    private final static Logger logger = LoggerFactory.getLogger(ApplicationConfig.class);
    public static final String SYSTEM_VARIABLE_CONFIG_LOCATION = "qrAdminConfigLocation";

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
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

    @Bean
    public MappingJackson2HttpMessageConverter jacksonMessageConverter() {
        return new MappingJackson2HttpMessageConverter(objectMapper());
    }

    @Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapper();
    }

    public final static void setSystemVariableConfigLocation() {
        logger.debug("System variable with name '" + ApplicationConfig.SYSTEM_VARIABLE_CONFIG_LOCATION + "' has value = '" + System.getProperty(ApplicationConfig.SYSTEM_VARIABLE_CONFIG_LOCATION) + "'");
        if ( null == System.getProperty(ApplicationConfig.SYSTEM_VARIABLE_CONFIG_LOCATION) ) {
            logger.debug("Set system variable with name '" + ApplicationConfig.SYSTEM_VARIABLE_CONFIG_LOCATION + "' as fake value.");
            System.setProperty(ApplicationConfig.SYSTEM_VARIABLE_CONFIG_LOCATION,"fake value");
        }
    }
}
