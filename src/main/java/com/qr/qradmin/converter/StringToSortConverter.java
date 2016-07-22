package com.qr.qradmin.converter;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.qr.qradmin.dto.filter.SortDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.domain.Sort;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StringToSortConverter implements Converter<String, Sort> {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    protected ObjectMapper objectMapper;

    @Override
    public Sort convert(String source) {
        if (source == null) return null;
        List<SortDto> sortDtos;
        try {
            sortDtos = objectMapper.readValue(source, new TypeReference<List<SortDto>>() {});
        } catch (IOException e) {
            logger.error("wrong sort format", e);
            return null;
        }
        if (CollectionUtils.isEmpty(sortDtos)) {
            return null;
        }
        List<Sort.Order> orders = new ArrayList<>();
        for (SortDto sortDto : sortDtos) {
            orders.add(new Sort.Order(sortDto.getDirection(), sortDto.getProperty()));
        }
        return new Sort(orders);
    }
}
