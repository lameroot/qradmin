package com.qr.qradmin.service.dto;

import com.qr.qradmin.dto.entity.MerchantDto;
import com.qr.qradmin.filter.MerchantFilter;
import com.qr.qradmin.generic.EntityFilter;
import com.qr.qradmin.generic.GenericDtoService;
import com.qr.qradmin.generic.GenericEntityService;
import com.qr.qradmin.service.entity.MerchantService;
import org.springframework.stereotype.Service;
import ru.qrhandshake.qrpos.domain.Merchant;

import javax.annotation.Resource;
import java.util.Map;

@Service
public class MerchantDtoService extends GenericDtoService<Merchant, MerchantDto> {

    @Resource
    private MerchantService merchantService;

    @Override
    protected EntityFilter buildFilter(Map<String, String> filter) {
        MerchantFilter entityFilter = new MerchantFilter();
        return entityFilter;
    }

    @Override
    protected Class<Merchant> getEClass() {
        return Merchant.class;
    }

    @Override
    protected Class<MerchantDto> getEDtoClass() {
        return MerchantDto.class;
    }

    @Override
    protected GenericEntityService<Merchant> getEntityService() {
        return merchantService;
    }
}
