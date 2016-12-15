package com.qr.qradmin.converter;

import com.qr.qradmin.dto.entity.OrderTemplateDto;
import com.qr.qradmin.service.entity.TerminalService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import ru.qrhandshake.qrpos.domain.OrderTemplate;

import javax.annotation.Resource;

@Component
public class OrderTemplateToEntityConverter implements Converter<OrderTemplateDto, OrderTemplate> {

    @Resource
    private TerminalService terminalService;

    @Override
    public OrderTemplate convert(OrderTemplateDto orderTemplateDto) {
        if (orderTemplateDto == null) return null;
        OrderTemplate orderTemplate = new OrderTemplate();
        if (orderTemplateDto.getTerminalId() != null){
            orderTemplate.setTerminal(terminalService.get(orderTemplateDto.getTerminalId()));
        }
        orderTemplate.setAmount(orderTemplateDto.getAmount());
        orderTemplate.setName(orderTemplateDto.getName());
        orderTemplate.setDescription(orderTemplateDto.getDescription());

        return orderTemplate;
    }
}
