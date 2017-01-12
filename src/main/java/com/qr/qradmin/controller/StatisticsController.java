package com.qr.qradmin.controller;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.qr.qradmin.dto.entity.StatisticPointDto;
import com.qr.qradmin.dto.filter.StatisticFilterDto;
import com.qr.qradmin.generic.PageResponse;
import com.qr.qradmin.generic.PageableFilterDto;
import com.qr.qradmin.service.ErrorService;
import com.qr.qradmin.validator.filter.StatisticFilterDtoValidator;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/api/statistics")
public class StatisticsController {

    @Resource
    private StatisticFilterDtoValidator statisticFilterDtoValidator;
    @Resource
    private ErrorService errorService;

    @RequestMapping
    @ResponseBody
    public PageResponse<StatisticPointDto> get(@RequestBody PageableFilterDto<StatisticFilterDto> pageableFilter, BindingResult result) {
        statisticFilterDtoValidator.validate(pageableFilter, result);
        if (result.hasErrors()) {
            return errorService.generateErrorPageResponse(result);
        }

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
