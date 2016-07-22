package com.qr.qradmin.converter;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.qr.qradmin.model.FilterDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.convert.converter.Converter;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;

public class StringToFilterDtoConverter implements Converter<String, FilterDto> {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    protected ObjectMapper objectMapper;

    @Override
    public FilterDto convert(String source) {
        if (source == null) return null;
        List<FilterDto.SingleFilter> singleFilters;
        try {
            singleFilters = objectMapper.readValue(source, new TypeReference<List<FilterDto.SingleFilter>>() {});
        } catch (IOException e) {
            logger.error("wrong filter format", e);
            return null;
        }
        return new FilterDto(singleFilters);
    }
}
