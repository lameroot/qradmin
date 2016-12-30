package com.qr.qradmin.service.dto;

import com.qr.qradmin.dto.entity.OrderTemplateDto;
import com.qr.qradmin.dto.filter.OrderTemplateFilterDto;
import com.qr.qradmin.filter.OrderTemplateFilter;
import com.qr.qradmin.generic.EntityFilter;
import com.qr.qradmin.generic.GenericDtoService;
import com.qr.qradmin.generic.GenericEntityService;
import com.qr.qradmin.service.entity.OrderTemplateService;
import com.qr.qradmin.service.entity.TerminalService;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import ru.qrhandshake.qrpos.domain.OrderTemplate;
import ru.qrhandshake.qrpos.domain.Terminal;
import ru.qrhandshake.qrpos.domain.User;
import ru.qrhandshake.qrpos.util.SecurityUtils;

import javax.annotation.Resource;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class OrderTemplateDtoService extends GenericDtoService<OrderTemplate, OrderTemplateDto, OrderTemplateFilterDto> {

    @Resource
    private OrderTemplateService orderTemplateService;
    @Resource
    private TerminalService terminalService;


    @Override
    protected EntityFilter buildFilter(OrderTemplateFilterDto filter) {
        OrderTemplateFilter entityFilter = new OrderTemplateFilter();
        if (!SecurityUtils.isCurrentUserAdmin()) {          //TODO сделать отдельный метод для получения своих записей
            User user = SecurityUtils.getCurrentUser();
            Set<Terminal> terminals = terminalService.findByMerchant(user.getMerchant());
            if ( terminals.isEmpty() ) {
                entityFilter.setTerminalIds(nullList);
            }
            else {
                List<Long> merchantTerminalIds = terminals.stream()
                        .map(Terminal::getId)
                        .collect(Collectors.toList());
                entityFilter.setTerminalIds(merchantTerminalIds);
            }
        }

        entityFilter.setAmountFrom(filter.getAmountFrom());
        entityFilter.setAmountTo(filter.getAmountTo());
        return entityFilter;
    }

    @Override
    protected Class<OrderTemplate> getEClass() {
        return OrderTemplate.class;
    }

    @Override
    protected Class<OrderTemplateDto> getEDtoClass() {
        return OrderTemplateDto.class;
    }

    @Override
    protected GenericEntityService<OrderTemplate> getEntityService() {
        return orderTemplateService;
    }
}
