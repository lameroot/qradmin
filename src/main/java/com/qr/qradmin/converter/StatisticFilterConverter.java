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
        filter.setDateFrom(filterDto.getDateFrom());
        filter.setDateTo(filterDto.getDateTo());
        filter.setGrouping(filterDto.getGrouping());
        filter.setCalculationType(filterDto.getCalculationType());
        filter.setIndicatorType(filterDto.getIndicatorType());
        filter.setSelectedOrderTemplatesIds(null != filterDto.getSelectedOrderTemplatesIds() ? filterDto.getSelectedOrderTemplatesIds().toArray(new Long[]{}) : null);
        filter.setSelectedTerminalsIds(null != filterDto.getSelectedTerminalsIds() ? filterDto.getSelectedTerminalsIds().toArray(new Long[]{}) : null);
        filter.setSeparatelyForOrderTemplates(filterDto.isSeparatelyForOrderTemplates());
        filter.setSeparatelyForTerminals(filterDto.isSeparatelyForTerminals());

        return filter;
    }
}
