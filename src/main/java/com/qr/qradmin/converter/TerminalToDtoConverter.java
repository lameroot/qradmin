package com.qr.qradmin.converter;

import com.qr.qradmin.dto.entity.TerminalDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import ru.qrhandshake.qrpos.domain.Terminal;

@Component
public class TerminalToDtoConverter implements Converter<Terminal, TerminalDto> {

    @Override
    public TerminalDto convert(Terminal terminal) {
        if (terminal == null) return null;
        TerminalDto terminalDto = new TerminalDto();
        terminalDto.setId(terminal.getId());
        terminalDto.setMerchantName(terminal.getMerchant().getName());
        terminalDto.setMerchantId(terminal.getMerchant().getId());
        terminalDto.setAuthName(terminal.getAuthName());
        return terminalDto;
    }
}
