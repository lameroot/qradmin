package com.qr.qradmin.service.dto;

import com.qr.qradmin.dto.entity.MerchantOrderDto;
import com.qr.qradmin.dto.filter.MerchantOrderFilterDto;
import com.qr.qradmin.filter.MerchantOrderFilter;
import com.qr.qradmin.generic.GenericDtoService;
import com.qr.qradmin.generic.GenericEntityService;
import com.qr.qradmin.service.entity.MerchantOrderService;
import org.springframework.stereotype.Service;
import ru.qrhandshake.qrpos.domain.MerchantOrder;

import javax.annotation.Resource;

@Service
public class MerchantOrderDtoService extends GenericDtoService<MerchantOrder, MerchantOrderFilter, MerchantOrderDto, MerchantOrderFilterDto> {

    @Resource
    private MerchantOrderService merchantOrderService;

    @Override
    protected Class<MerchantOrder> getEClass() {
        return MerchantOrder.class;
    }

    @Override
    protected Class<MerchantOrderDto> getEDtoClass() {
        return MerchantOrderDto.class;
    }

    @Override
    protected Class<MerchantOrderFilter> getEFilterClass() {
        return MerchantOrderFilter.class;
    }

    @Override
    protected GenericEntityService<MerchantOrder, MerchantOrderFilter> getEntityService() {
        return merchantOrderService;
    }
}
