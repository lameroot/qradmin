package com.qr.qradmin.converter;

import com.qr.qradmin.dto.filter.StatisticFilterDto;
import com.qr.qradmin.filter.StatisticFilter;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class StatisticFilterConverter implements Converter<StatisticFilterDto, StatisticFilter> {

    @Override
    public StatisticFilter convert(StatisticFilterDto filterDto) {
        StatisticFilter filter = new StatisticFilter();
        return filter;
    }
}
