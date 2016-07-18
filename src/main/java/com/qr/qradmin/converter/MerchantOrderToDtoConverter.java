package com.qr.qradmin.converter;

import com.qr.qradmin.dto.entity.MerchantOrderDto;
import com.qr.qradmin.dto.entity.UserDto;
import org.springframework.core.convert.converter.Converter;
import ru.qrhandshake.qrpos.domain.*;

import java.util.Date;
import java.util.Optional;

public class MerchantOrderToDtoConverter implements Converter<MerchantOrder, MerchantOrderDto> {

    @Override
    public MerchantOrderDto convert(MerchantOrder order) {
        if (order == null) return null;
        MerchantOrderDto merchantOrderDto = new MerchantOrderDto();

        merchantOrderDto.setOrderId(order.getOrderId());
        merchantOrderDto.setCreatedDate(order.getCreatedDate());
        merchantOrderDto.setPaymentDate(order.getPaymentDate());
        merchantOrderDto.setAmount(order.getAmount());
        merchantOrderDto.setDescription(order.getDescription());
        merchantOrderDto.setDeviceId(order.getDeviceId());
        merchantOrderDto.setMerchantId(order.getMerchant().getId());
        merchantOrderDto.setTerminalId(order.getTerminal().getId());
        merchantOrderDto.setClientId(Optional.ofNullable(order.getClient()).map(Client::getId).orElse(null));
        merchantOrderDto.setIntegrationSupport(order.getIntegrationSupport());
        merchantOrderDto.setOrderStatus(order.getOrderStatus());
        merchantOrderDto.setSessionId(order.getSessionId());
        merchantOrderDto.setPaymentSecureType(order.getPaymentSecureType());
        merchantOrderDto.setPaymentWay(order.getPaymentWay());
        merchantOrderDto.setPaymentType(order.getPaymentType());

        return merchantOrderDto;
    }
}
