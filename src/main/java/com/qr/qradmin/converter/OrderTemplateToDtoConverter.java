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
        if (orderTemplate.getTerminal() != null) {
            orderTemplateDto.setTerminalId(orderTemplate.getTerminal().getId());
        }
        if (orderTemplate.getTerminal() != null && orderTemplate.getTerminal().getMerchant() != null) {
            orderTemplateDto.setMerchantId(orderTemplate.getTerminal().getMerchant().getId());
        }
        orderTemplateDto.setAmount(orderTemplate.getAmount());
        orderTemplateDto.setName(orderTemplate.getName());
        orderTemplateDto.setDescription(orderTemplate.getDescription());

        return orderTemplateDto;
    }
}
