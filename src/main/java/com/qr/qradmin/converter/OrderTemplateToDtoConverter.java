package com.qr.qradmin.converter;

import com.qr.qradmin.dto.entity.OrderTemplateDto;
import org.springframework.core.convert.converter.Converter;
import ru.qrhandshake.qrpos.domain.OrderTemplate;

public class OrderTemplateToDtoConverter implements Converter<OrderTemplate, OrderTemplateDto> {

    @Override
    public OrderTemplateDto convert(OrderTemplate orderTemplate) {
        if (orderTemplate == null) return null;
        OrderTemplateDto orderTemplateDto = new OrderTemplateDto();

        orderTemplateDto.setId(orderTemplate.getId());
        orderTemplateDto.setTerminalId(orderTemplate.getTerminal().getId());
        orderTemplateDto.setTerminalName(orderTemplate.getTerminal().getAuthName());
        orderTemplateDto.setMerchantId(orderTemplate.getTerminal().getMerchant().getId());
        orderTemplateDto.setMerchantName(orderTemplate.getTerminal().getMerchant().getName());
        orderTemplateDto.setAmount(orderTemplate.getAmount());
        orderTemplateDto.setName(orderTemplate.getName());
        orderTemplateDto.setDescription(orderTemplate.getDescription());

        return orderTemplateDto;
    }
}
