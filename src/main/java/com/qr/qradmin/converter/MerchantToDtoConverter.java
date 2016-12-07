package com.qr.qradmin.converter;

import com.qr.qradmin.dto.entity.MerchantDto;
import com.qr.qradmin.service.entity.UserService;
import org.springframework.core.convert.converter.Converter;
import ru.qrhandshake.qrpos.domain.Merchant;
import ru.qrhandshake.qrpos.domain.Terminal;
import ru.qrhandshake.qrpos.domain.User;
import ru.qrhandshake.qrpos.service.TerminalService;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class MerchantToDtoConverter implements Converter<Merchant, MerchantDto> {

    @Resource
    private TerminalService terminalService;
    @Resource
    private UserService userService;

    @Override
    public MerchantDto convert(Merchant merchant) {
        if (merchant == null) return null;
        MerchantDto merchantDto = new MerchantDto();

        merchantDto.setId(merchant.getId());
        merchantDto.setName(merchant.getName());
        merchantDto.setDescription(merchant.getDescription());
        merchantDto.setCreatedDate(merchant.getCreatedDate());
        merchantDto.setIntegrationSupport(merchant.getIntegrationSupport());
        Set<Terminal> terminals = terminalService.findByMerchant(merchant);
        merchantDto.setTerminalIds(
                Optional.ofNullable(terminals).orElse(Collections.emptySet())
                .stream().map(Terminal::getId).collect(Collectors.toSet())
        );
        Set<User> users = userService.findByMerchant(merchant);
        merchantDto.setUserIds(Optional.ofNullable(users).orElse(Collections.emptySet())
                .stream().map(User::getId).collect(Collectors.toSet())
        );
        merchantDto.setCreateBinding(merchant.isCreateBinding());

        return merchantDto;
    }
}
