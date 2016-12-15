package com.qr.qradmin.converter;

import com.qr.qradmin.dto.entity.MerchantDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import ru.qrhandshake.qrpos.domain.Merchant;

@Component
public class MerchantToEntityConverter implements Converter<MerchantDto, Merchant> {

    @Override
    public Merchant convert(MerchantDto merchantDto) {
        if (merchantDto == null) return null;
        Merchant merchant = new Merchant();

        merchant.setName(merchantDto.getName());
        merchant.setDescription(merchantDto.getDescription());

        return merchant;
    }
}
