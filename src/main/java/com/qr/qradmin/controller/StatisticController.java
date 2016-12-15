package com.qr.qradmin.controller;

import com.qr.qradmin.dto.entity.StatisticDto;
import com.qr.qradmin.generic.GenericController;
import com.qr.qradmin.generic.GenericDtoService;
import com.qr.qradmin.service.dto.StatisticDtoService;
import com.qr.qradmin.validator.entity.StatisticDtoValidator;
import com.qr.qradmin.validator.filter.StatisticFilterDtoValidator;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.qrhandshake.qrpos.domain.Statistic;

import javax.annotation.Resource;

@Controller
@RequestMapping("/api/statistics")
public class StatisticController extends GenericController<Statistic,StatisticDto> {

    @Resource
    private StatisticDtoService statisticDtoService;
    @Resource
    private StatisticDtoValidator statisticDtoValidator;
    @Resource
    private StatisticFilterDtoValidator statisticFilterDtoValidator;

    @Override
    protected Validator getEntityValidator() {
        return statisticDtoValidator;
    }

    @Override
    protected Validator getFilterValidator() {
        return statisticFilterDtoValidator;
    }

    @Override
    protected GenericDtoService<Statistic, StatisticDto> getDtoService() {
        return statisticDtoService;
    }
}
