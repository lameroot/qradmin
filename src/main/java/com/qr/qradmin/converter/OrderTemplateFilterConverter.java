package com.qr.qradmin.converter;

import com.qr.qradmin.dto.filter.OrderTemplateFilterDto;
import com.qr.qradmin.filter.OrderTemplateFilter;
import com.qr.qradmin.service.entity.TerminalService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import ru.qrhandshake.qrpos.domain.Terminal;
import ru.qrhandshake.qrpos.domain.User;
import ru.qrhandshake.qrpos.util.SecurityUtils;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class OrderTemplateFilterConverter implements Converter<OrderTemplateFilterDto, OrderTemplateFilter> {

    @Resource
    private TerminalService terminalService;
    @Override
    public OrderTemplateFilter convert(OrderTemplateFilterDto filterDto) {
        OrderTemplateFilter filter = new OrderTemplateFilter();
        if (!SecurityUtils.isCurrentUserAdmin()) {          //TODO сделать отдельный метод для получения своих записей
            User user = SecurityUtils.getCurrentUser();
            Set<Terminal> terminals = terminalService.findByMerchant(user.getMerchant());
            if ( terminals.isEmpty() ) {
                filter.setTerminalIds(Collections.emptyList());
            }
            else {
                List<Long> merchantTerminalIds = terminals.stream()
                        .map(Terminal::getId)
                        .collect(Collectors.toList());
                filter.setTerminalIds(merchantTerminalIds);
            }
        }

        if (filterDto == null) {
            return filter;
        }

        filter.setAmountFrom(filterDto.getAmountFrom());
        filter.setAmountTo(filterDto.getAmountTo());
        return filter;
    }
}
