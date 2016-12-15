package com.qr.qradmin.converter;

import com.qr.qradmin.dto.entity.OrderTemplateDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import ru.qrhandshake.qrpos.domain.OrderTemplate;

@Component
public class OrderTemplateToDtoConverter implements Converter<OrderTemplate, OrderTemplateDto> {

    private final static Logger logger = LoggerFactory.getLogger(OrderTemplateToDtoConverter.class);

    @Override
    public OrderTemplateDto convert(OrderTemplate orderTemplate) {
        if (orderTemplate == null) return null;
        OrderTemplateDto orderTemplateDto = new OrderTemplateDto();

        if ( orderTemplate.getTerminal() == null ) {
            logger.warn("In system has orderTemplate with name : [{}] which has not terminal.", orderTemplate.getName());
            return null;
        }
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
