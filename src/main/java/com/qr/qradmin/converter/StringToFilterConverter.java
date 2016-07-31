package com.qr.qradmin.converter;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.qr.qradmin.enums.ErrorCode;
import com.qr.qradmin.generic.GeneralException;
import com.qr.qradmin.model.Filter;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.convert.converter.Converter;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.Map;

public class StringToFilterConverter implements Converter<String, Filter> {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    protected ObjectMapper objectMapper;

    @Override
    public Filter convert(String source) {
        if (StringUtils.isBlank(source)) return null;
        try {
            Map<String, String> filters = objectMapper.readValue(source, new TypeReference<Map>() {
            });
            return new Filter(filters);
        } catch (IOException e) {
            logger.error("wrong filter format", e);
            throw new GeneralException(ErrorCode.BAD_REQUEST);
        }
    }
}
