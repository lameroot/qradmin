package com.qr.qradmin.service.dto;

import com.qr.qradmin.dto.entity.TerminalDto;
import com.qr.qradmin.filter.TerminalFilter;
import com.qr.qradmin.generic.EntityFilter;
import com.qr.qradmin.generic.GenericDtoService;
import com.qr.qradmin.generic.GenericEntityService;
import com.qr.qradmin.service.entity.TerminalService;
import org.springframework.stereotype.Service;
import ru.qrhandshake.qrpos.domain.Terminal;

import javax.annotation.Resource;
import java.util.Map;

@Service
public class TerminalDtoService extends GenericDtoService<Terminal, TerminalDto> {

    @Resource
    private TerminalService terminalService;

    @Override
    protected EntityFilter buildFilter(Map<String, String> filter) {
        TerminalFilter entityFilter = new TerminalFilter();
        return entityFilter;
    }

    @Override
    protected Class<Terminal> getEClass() {
        return Terminal.class;
    }

    @Override
    protected Class<TerminalDto> getEDtoClass() {
        return TerminalDto.class;
    }

    @Override
    protected GenericEntityService<Terminal> getEntityService() {
        return terminalService;
    }
}
