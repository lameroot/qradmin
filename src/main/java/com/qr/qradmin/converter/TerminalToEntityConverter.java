package com.qr.qradmin.converter;

import com.qr.qradmin.dto.entity.TerminalDto;
import com.qr.qradmin.service.entity.MerchantService;
import org.springframework.core.convert.converter.Converter;
import ru.qrhandshake.qrpos.domain.Merchant;
import ru.qrhandshake.qrpos.domain.Terminal;

import javax.annotation.Resource;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class TerminalToEntityConverter implements Converter<TerminalDto, Terminal> {

    @Resource
    private MerchantService merchantService;

    @Override
    public Terminal convert(TerminalDto teminalDto) {
        if (teminalDto == null) return null;
        Terminal terminal = new Terminal();
        if (teminalDto.getMerchantId() != null) {
            terminal.setMerchant(merchantService.get(teminalDto.getMerchantId()));
        }
        terminal.setAuthName(teminalDto.getAuthName());
        return terminal;
    }
}
