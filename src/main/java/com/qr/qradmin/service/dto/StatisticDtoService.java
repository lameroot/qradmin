package com.qr.qradmin.service.dto;

import com.qr.qradmin.dto.entity.StatisticDto;
import com.qr.qradmin.generic.EntityFilter;
import com.qr.qradmin.generic.GenericDtoService;
import com.qr.qradmin.generic.GenericEntityService;
import com.qr.qradmin.service.entity.StatisticAdminService;
import org.springframework.stereotype.Service;
import ru.qrhandshake.qrpos.domain.Statistic;

import javax.annotation.Resource;
import java.util.Map;

@Service
public class StatisticDtoService extends GenericDtoService<Statistic, StatisticDto> {

    @Resource
    private StatisticAdminService statisticAdminService;

    @Override
    protected EntityFilter buildFilter(Map<String, String> filter) {
        return null;
    }

    @Override
    protected Class<Statistic> getEClass() {
        return Statistic.class;
    }

    @Override
    protected Class<StatisticDto> getEDtoClass() {
        return StatisticDto.class;
    }

    @Override
    protected GenericEntityService<Statistic> getEntityService() {
        return statisticAdminService;
    }
}
