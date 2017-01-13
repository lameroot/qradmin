package com.qr.qradmin.service.dto;

import com.qr.qradmin.dto.entity.StatisticPointDto;
import com.qr.qradmin.dto.filter.StatisticFilterDto;
import com.qr.qradmin.filter.StatisticFilter;
import com.qr.qradmin.generic.PageResponse;
import com.qr.qradmin.model.StatisticPoint;
import com.qr.qradmin.service.entity.StatisticAdminService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StatisticDtoService {

    private Logger logger = LoggerFactory.getLogger(StatisticDtoService.class);

    @Resource
    private StatisticAdminService statisticAdminService;
    @Resource
    private ConversionService conversionService;

    private StatisticFilter buildFilter(StatisticFilterDto filterDto) {
        return new StatisticFilter();
    }

    public PageResponse<StatisticPointDto> get(StatisticFilterDto filterDto) {
        StatisticFilter filter = buildFilter(filterDto);
        List<StatisticPoint> points = statisticAdminService.get(filter);
        List<StatisticPointDto> pointDtos = points.stream()
                .map(point -> conversionService.convert(point, StatisticPointDto.class))
                .collect(Collectors.toList());
        return new PageResponse<>(pointDtos, pointDtos.size());
    }

}
