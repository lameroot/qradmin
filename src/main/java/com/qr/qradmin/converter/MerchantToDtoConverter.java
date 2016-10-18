package com.qr.qradmin.converter;

import com.qr.qradmin.dto.entity.MerchantDto;
import com.qr.qradmin.dto.entity.UserDto;
import org.springframework.core.convert.converter.Converter;
import ru.qrhandshake.qrpos.domain.IntegrationSupport;
import ru.qrhandshake.qrpos.domain.Merchant;
import ru.qrhandshake.qrpos.domain.Terminal;
import ru.qrhandshake.qrpos.domain.User;

import java.util.Date;
import java.util.Set;
import java.util.stream.Collectors;

public class MerchantToDtoConverter implements Converter<Merchant, MerchantDto> {

    @Override
    public MerchantDto convert(Merchant merchant) {
        if (merchant == null) return null;
        MerchantDto merchantDto = new MerchantDto();

        merchantDto.setId(merchant.getId());
        merchantDto.setName(merchant.getName());
        merchantDto.setDescription(merchant.getDescription());
        merchantDto.setCreatedDate(merchant.getCreatedDate());
        merchantDto.setIntegrationSupport(merchant.getIntegrationSupport());
        merchantDto.setTerminalIds(merchant.getTerminals().stream().map(Terminal::getId).collect(Collectors.toSet()));
        merchantDto.setUserIds(merchant.getUsers().stream().map(User::getId).collect(Collectors.toSet()));
        merchantDto.setCreateBinding(merchant.isCreateBinding());

        return merchantDto;
    }
}
