package com.qr.qradmin.controller;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.qr.qradmin.dto.entity.StatisticsPointDto;
import com.qr.qradmin.dto.filter.StatisticFilterDto;
import com.qr.qradmin.generic.PageResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/api/statistics")
public class StatisticController  {

    @RequestMapping
    @ResponseBody
    public PageResponse<StatisticsPointDto> get(@RequestBody StatisticFilterDto filter) {

        StatisticsPointDto point1 = new StatisticsPointDto();
        point1.setX("1");
        point1.setY(ImmutableMap.of(
                1L, 7L,
                3L, 9L,
                5L, 1L
        ));

        StatisticsPointDto point2 = new StatisticsPointDto();
        point2.setX("2");
        point2.setY(ImmutableMap.of(
                1L, 4L,
                3L, 2L,
                5L, 7L
        ));

        StatisticsPointDto point3 = new StatisticsPointDto();
        point3.setX("3");
        point3.setY(ImmutableMap.of(
                1L, 8L,
                3L, 3L,
                5L, 5L
        ));

        List<StatisticsPointDto> points = ImmutableList.of(
                point1,
                point2,
                point3
        );

        return new PageResponse<>(points, points.size());
    }
}
