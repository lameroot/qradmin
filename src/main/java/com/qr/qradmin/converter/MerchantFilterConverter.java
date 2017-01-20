package com.qr.qradmin.converter;

import com.qr.qradmin.dto.filter.MerchantFilterDto;
import com.qr.qradmin.filter.MerchantFilter;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class MerchantFilterConverter implements Converter<MerchantFilterDto, MerchantFilter> {

    @Override
    public MerchantFilter convert(MerchantFilterDto filterDto) {
        if (filterDto == null) return null;
        MerchantFilter filter = new MerchantFilter();
        return filter;
    }
}
