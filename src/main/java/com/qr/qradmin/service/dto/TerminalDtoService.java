package com.qr.qradmin.service.dto;

import com.qr.qradmin.dto.entity.TerminalDto;
import com.qr.qradmin.filter.TerminalFilter;
import com.qr.qradmin.generic.EntityFilter;
import com.qr.qradmin.generic.GenericDtoService;
import com.qr.qradmin.generic.GenericEntityService;
import com.qr.qradmin.service.entity.TerminalService;
import org.springframework.stereotype.Service;
import ru.qrhandshake.qrpos.domain.Terminal;
import ru.qrhandshake.qrpos.domain.User;
import ru.qrhandshake.qrpos.util.SecurityUtils;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class TerminalDtoService extends GenericDtoService<Terminal, TerminalDto> {

    @Resource
    private TerminalService terminalService;

    @Override
    protected EntityFilter buildFilter(Map<String, String> filter) {
        TerminalFilter entityFilter = new TerminalFilter();
        if (!SecurityUtils.isCurrentUserAdmin()) {          //TODO сделать отдельный метод для получения своих записей
            User user = SecurityUtils.getCurrentUser();
            List<Long> merchantTerminalIds = user.getMerchant().getTerminals().stream()
                    .map(Terminal::getId)
                    .collect(Collectors.toList());
            entityFilter.setTerminalIds(merchantTerminalIds);
        }
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
