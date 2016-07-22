package com.qr.qradmin.converter;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.qr.qradmin.model.Filter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.convert.converter.Converter;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;

public class FilterToEntityConverter implements Converter<String, Filter> {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    protected ObjectMapper objectMapper;

    @Override
    public Filter convert(String source) {
        if (source == null) return null;
        List<Filter.SingleFilter> singleFilters;
        try {
            singleFilters = objectMapper.readValue(source, new TypeReference<List<Filter.SingleFilter>>() {});
        } catch (IOException e) {
            logger.error("wrong filter format", e);
            return null;
        }
        return new Filter(singleFilters);
    }
}
