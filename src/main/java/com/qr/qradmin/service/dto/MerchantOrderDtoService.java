package com.qr.qradmin.service.dto;

import com.qr.qradmin.dto.entity.MerchantOrderDto;
import com.qr.qradmin.dto.filter.MerchantOrderFilterDto;
import com.qr.qradmin.filter.MerchantOrderFilter;
import com.qr.qradmin.generic.EntityFilter;
import com.qr.qradmin.generic.GenericDtoService;
import com.qr.qradmin.generic.GenericEntityService;
import com.qr.qradmin.service.entity.MerchantOrderService;
import org.springframework.stereotype.Service;
import ru.qrhandshake.qrpos.domain.MerchantOrder;

import javax.annotation.Resource;

@Service
public class MerchantOrderDtoService extends GenericDtoService<MerchantOrder, MerchantOrderDto, MerchantOrderFilterDto> {

    @Resource
    private MerchantOrderService merchantOrderService;

    @Override
    protected EntityFilter buildFilter(MerchantOrderFilterDto pageableFilterDto) {
        MerchantOrderFilter filter = new MerchantOrderFilter(pageableFilterDto);
        return filter;
    }

    @Override
    protected Class<MerchantOrder> getEClass() {
        return MerchantOrder.class;
    }

    @Override
    protected Class<MerchantOrderDto> getEDtoClass() {
        return MerchantOrderDto.class;
    }

    @Override
    protected GenericEntityService<MerchantOrder> getEntityService() {
        return merchantOrderService;
    }
}
