package com.qr.qradmin.service.dto;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.qr.qradmin.dto.entity.StatisticPointDto;
import com.qr.qradmin.dto.filter.StatisticFilterDto;
import com.qr.qradmin.generic.PageResponse;
import com.qr.qradmin.service.entity.StatisticAdminService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class StatisticDtoService {

    private Logger logger = LoggerFactory.getLogger(StatisticDtoService.class);

    @Resource
    private StatisticAdminService statisticAdminService;

    public PageResponse<StatisticPointDto> buildStatisticPage(StatisticFilterDto filterDto) {
        StatisticPointDto point1 = new StatisticPointDto();
        point1.setX("Jan");
        point1.setY(ImmutableMap.of(
                1L, 7L,
                3L, 9L,
                5L, 1L
        ));

        StatisticPointDto point2 = new StatisticPointDto();
        point2.setX("Feb");
        point2.setY(ImmutableMap.of(
                1L, 4L,
                3L, 2L,
                5L, 7L
        ));

        StatisticPointDto point3 = new StatisticPointDto();
        point3.setX("Mar");
        point3.setY(ImmutableMap.of(
                1L, 8L,
                3L, 3L,
                5L, 5L
        ));

        List<StatisticPointDto> points = ImmutableList.of(
                point1,
                point2,
                point3
        );

        return new PageResponse<>(points, points.size());
    }

}
