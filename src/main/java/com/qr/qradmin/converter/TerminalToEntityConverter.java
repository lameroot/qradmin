package com.qr.qradmin.converter;

import com.qr.qradmin.dto.entity.TerminalDto;
import com.qr.qradmin.service.entity.MerchantService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import ru.qrhandshake.qrpos.domain.Terminal;

import javax.annotation.Resource;

@Component
public class TerminalToEntityConverter implements Converter<TerminalDto, Terminal> {

    @Resource
    private MerchantService merchantService;

    @Override
    public Terminal convert(TerminalDto terminalDto) {
        if (terminalDto == null) return null;
        Terminal terminal = new Terminal();
        if (terminalDto.getMerchantId() != null) {
            terminal.setMerchant(merchantService.get(terminalDto.getMerchantId()));
        }
        terminal.setAuthName(terminalDto.getAuthName());
        terminal.setAuthPassword(terminalDto.getAuthPassword());
        terminal.setEnabled(true);
        return terminal;
    }
}
