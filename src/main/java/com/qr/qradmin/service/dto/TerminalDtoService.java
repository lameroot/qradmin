package com.qr.qradmin.service.dto;

import com.qr.qradmin.dto.entity.TerminalDto;
import com.qr.qradmin.dto.filter.TerminalFilterDto;
import com.qr.qradmin.filter.TerminalFilter;
import com.qr.qradmin.generic.GenericDtoService;
import com.qr.qradmin.generic.GenericEntityService;
import com.qr.qradmin.service.entity.TerminalService;
import org.springframework.stereotype.Service;
import ru.qrhandshake.qrpos.domain.Terminal;

import javax.annotation.Resource;

@Service
public class TerminalDtoService extends GenericDtoService<Terminal, TerminalFilter, TerminalDto, TerminalFilterDto> {

    @Resource
    private TerminalService terminalService;

    @Override
    protected Class<Terminal> getEClass() {
        return Terminal.class;
    }

    @Override
    protected Class<TerminalDto> getEDtoClass() {
        return TerminalDto.class;
    }

    @Override
    protected Class<TerminalFilter> getEFilterClass() {
        return TerminalFilter.class;
    }

    @Override
    protected GenericEntityService<Terminal, TerminalFilter> getEntityService() {
        return terminalService;
    }
}
