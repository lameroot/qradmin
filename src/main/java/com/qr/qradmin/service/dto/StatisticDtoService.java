package com.qr.qradmin.service.dto;

import com.qr.qradmin.dto.entity.StatisticJsonDto;
import com.qr.qradmin.filter.StatisticFilter;
import com.qr.qradmin.generic.*;
import com.qr.qradmin.model.Filter;
import com.qr.qradmin.service.entity.StatisticAdminService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import ru.qrhandshake.qrpos.domain.Statistic;
import ru.qrhandshake.qrpos.util.SecurityUtils;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class StatisticDtoService {

    private Logger logger = LoggerFactory.getLogger(StatisticDtoService.class);

    @Resource
    private StatisticAdminService statisticAdminService;


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

    public ElementResponse<StatisticJsonDto> get(PageableFilterDto filterDto) {
        Map<String, String> filter = Optional.ofNullable(filterDto.getFilter()).map(Filter::getFilters).orElse(null);
        StatisticFilter statisticFilter = (StatisticFilter)buildFilter(filter);

        StatisticJsonDto statisticJsonDto = new StatisticJsonDto();
        for (StatisticFilter.Slot slot : statisticFilter.getTimeSlot().getSlots(statisticFilter.getBefore())) {
            for (Long orderTemplateId : statisticFilter.getOrderTemplateIds()) {
                Long value = statisticAdminService.sumByPeriod(Statistic.StatisticType.TEMPLATE_AMOUNT_PAID, slot.getStartTime(), slot.getEndTime(), statisticFilter.getMerchantId(), orderTemplateId);
                String orderTemplateName = String.valueOf(orderTemplateId);//todo: name
                statisticJsonDto.addDataForOrderTemplate(slot.getName(), orderTemplateName, value);
            }
        }

        ElementResponse<StatisticJsonDto> elementResponse = new ElementResponse<>(statisticJsonDto);
        return elementResponse;
    }
}
