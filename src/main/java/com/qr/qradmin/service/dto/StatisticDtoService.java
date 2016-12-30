package com.qr.qradmin.service.dto;

import com.qr.qradmin.service.entity.StatisticAdminService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class StatisticDtoService {

    private Logger logger = LoggerFactory.getLogger(StatisticDtoService.class);

    @Resource
    private StatisticAdminService statisticAdminService;

}
