package com.qr.qradmin.service.dto;

import com.qr.qradmin.dto.entity.MerchantDto;
import com.qr.qradmin.dto.filter.MerchantFilterDto;
import com.qr.qradmin.filter.MerchantFilter;
import com.qr.qradmin.generic.GenericDtoService;
import com.qr.qradmin.generic.GenericEntityService;
import com.qr.qradmin.service.entity.MerchantService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ru.qrhandshake.qrpos.domain.Merchant;

import javax.annotation.Resource;

@Service
public class MerchantDtoService extends GenericDtoService<Merchant, MerchantFilter, MerchantDto, MerchantFilterDto> {

    @Resource
    @Qualifier("qradmin")
    private MerchantService merchantService;

    @Override
    protected Class<Merchant> getEClass() {
        return Merchant.class;
    }

    @Override
    protected Class<MerchantDto> getEDtoClass() {
        return MerchantDto.class;
    }

    @Override
    protected Class<MerchantFilterDto> getEFilterDtoClass() {
        return MerchantFilterDto.class;
    }

    @Override
    protected Class<MerchantFilter> getEFilterClass() {
        return MerchantFilter.class;
    }

    @Override
    protected GenericEntityService<Merchant, MerchantFilter> getEntityService() {
        return merchantService;
    }
}
