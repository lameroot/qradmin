package com.qr.qradmin.controller;

import com.qr.qradmin.dto.entity.StatisticPointDto;
import com.qr.qradmin.dto.filter.StatisticFilterDto;
import com.qr.qradmin.generic.PageResponse;
import com.qr.qradmin.generic.PageableFilterDto;
import com.qr.qradmin.service.ErrorService;
import com.qr.qradmin.service.dto.StatisticDtoService;
import com.qr.qradmin.validator.filter.StatisticFilterDtoValidator;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("/api/statistics")
public class StatisticsController {

    @Resource
    private StatisticFilterDtoValidator statisticFilterDtoValidator;
    @Resource
    private ErrorService errorService;
    @Resource
    private StatisticDtoService statisticDtoService;

    @RequestMapping
    @ResponseBody
    public PageResponse<StatisticPointDto> get(@RequestBody PageableFilterDto<StatisticFilterDto> pageableFilter, BindingResult result) {
        statisticFilterDtoValidator.validate(pageableFilter, result);
        if (result.hasErrors()) {
            return errorService.generateErrorPageResponse(result);
        }

        return statisticDtoService.get(pageableFilter.getFilter());
    }
}
