package com.qr.qradmin.service.dto;

import com.qr.qradmin.dto.entity.StatisticDto;
import com.qr.qradmin.filter.StatisticFilter;
import com.qr.qradmin.generic.EntityFilter;
import com.qr.qradmin.generic.GenericDtoService;
import com.qr.qradmin.generic.GenericEntityService;
import com.qr.qradmin.service.entity.StatisticAdminService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import ru.qrhandshake.qrpos.domain.Statistic;
import ru.qrhandshake.qrpos.util.SecurityUtils;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

@Service
public class StatisticDtoService extends GenericDtoService<Statistic, StatisticDto> {

    private Logger logger = LoggerFactory.getLogger(StatisticDtoService.class);

    @Resource
    private StatisticAdminService statisticAdminService;

    @Override
    protected EntityFilter buildFilter(Map<String, String> filter) {
        StatisticFilter statisticFilter = new StatisticFilter();
        try {
            Calendar before = Calendar.getInstance();
            if ( null != filter.get("before") ) {
                Date date = new SimpleDateFormat().parse(filter.get("before"));
                before.setTime(date);
            }
            statisticFilter.setBefore(before);
            statisticFilter.setTimeSlot(StatisticFilter.TimeSlot.valueOf(filter.get("timeSlot")));
            //statisticFilter.setOrderTemplateIds(Arrays.asList(filter.get("orderTemplateIds").split(","));
            statisticFilter.setMerchantId(SecurityUtils.getCurrentUser().getMerchant().getId());
        } catch (Exception e) {
            logger.error("Error build statistic filter",e);
        }
        return statisticFilter;
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
