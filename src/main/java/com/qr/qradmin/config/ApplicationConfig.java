package com.qr.qradmin.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.StandardPasswordEncoder;

@Configuration
@ComponentScan(value = {"com.qr.qradmin.service","com.qr.qradmin.validator"})
@PropertySource(ignoreResourceNotFound = true,
        value = {
                "classpath:config/properties/application.properties",
                "${" + ApplicationConfig.SYSTEM_VARIABLE_CONFIG_LOCATION + "}"
        })
@EnableScheduling
@Import(value = {
        ConverterConfig.class,
        DatasourceConfig.class,
        SecurityConfig.class
})
public class ApplicationConfig {

    private final static Logger logger = LoggerFactory.getLogger(ApplicationConfig.class);
    public static final String SYSTEM_VARIABLE_CONFIG_LOCATION = "qrAdminConfigLocation";

    static {
        ApplicationConfig.setSystemVariableConfigLocation();
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Bean
    public MappingJackson2HttpMessageConverter jacksonMessageConverter() {
        return new MappingJackson2HttpMessageConverter(objectMapper());
    }

    @Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapper();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new StandardPasswordEncoder();
    }

    private static void setSystemVariableConfigLocation() {
        String configLocation = System.getProperty(ApplicationConfig.SYSTEM_VARIABLE_CONFIG_LOCATION);
        logger.debug("System variable with name [{}] has value [{}]", ApplicationConfig.SYSTEM_VARIABLE_CONFIG_LOCATION, configLocation);
        if (StringUtils.isBlank(configLocation)) {
            logger.debug("Set system variable [{}] to [fake value]", ApplicationConfig.SYSTEM_VARIABLE_CONFIG_LOCATION);
            System.setProperty(ApplicationConfig.SYSTEM_VARIABLE_CONFIG_LOCATION, "fake value");
        }
    }
}
