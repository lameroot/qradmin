package com.qr.qradmin.service.dto;

import com.qr.qradmin.dto.entity.MerchantOrderDto;
import com.qr.qradmin.dto.filter.MerchantOrderFilterDto;
import com.qr.qradmin.filter.MerchantOrderFilter;
import com.qr.qradmin.generic.EntityFilter;
import com.qr.qradmin.generic.GenericDtoService;
import com.qr.qradmin.generic.GenericEntityService;
import com.qr.qradmin.model.FilterDto;
import com.qr.qradmin.service.entity.MerchantOrderService;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import ru.qrhandshake.qrpos.domain.MerchantOrder;

import javax.annotation.Resource;
import java.util.Optional;

@Service
public class MerchantOrderDtoService extends GenericDtoService<MerchantOrder, MerchantOrderDto, MerchantOrderFilterDto> {

    @Resource
    private MerchantOrderService merchantOrderService;

    @Override
    protected EntityFilter buildFilter(FilterDto filterDto) {
        MerchantOrderFilter filter = new MerchantOrderFilter();
        if (filterDto == null || filterDto.getFilters() == null){
            return filter;
        }
        for (FilterDto.SingleFilter f : filterDto.getFilters()) {
            switch (f.getProperty()) {
                case "amountFrom":
                    filter.setAmountFrom(Long.valueOf(f.getValue()));
                    break;
                case "amountTo":
                    filter.setAmountTo(Long.valueOf(f.getValue()));
                    break;
                case "deviceId":
                    filter.setDeviceId(f.getValue());
                    break;
                case "orderId":
                    filter.setOrderId(f.getValue());
                    break;
            }
        }
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
