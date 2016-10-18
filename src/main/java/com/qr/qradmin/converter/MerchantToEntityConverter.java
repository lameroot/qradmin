package com.qr.qradmin.converter;

import com.qr.qradmin.dto.entity.MerchantDto;
import com.qr.qradmin.dto.entity.UserDto;
import org.springframework.core.convert.converter.Converter;
import ru.qrhandshake.qrpos.domain.IntegrationSupport;
import ru.qrhandshake.qrpos.domain.Merchant;
import ru.qrhandshake.qrpos.domain.Terminal;
import ru.qrhandshake.qrpos.domain.User;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

public class MerchantToEntityConverter implements Converter<MerchantDto, Merchant> {

    @Override
    public Merchant convert(MerchantDto merchantDto) {
        if (merchantDto == null) return null;
        Merchant merchant = new Merchant();

        merchant.setDescription(merchantDto.getDescription());
        merchant.setIntegrationSupport(merchantDto.getIntegrationSupport());
        merchant.setCreateBinding(merchantDto.isCreateBinding());

        return merchant;
    }
}
