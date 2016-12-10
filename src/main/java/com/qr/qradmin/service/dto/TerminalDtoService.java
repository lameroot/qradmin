package com.qr.qradmin.service.dto;

import com.qr.qradmin.dto.entity.TerminalDto;
import com.qr.qradmin.filter.TerminalFilter;
import com.qr.qradmin.generic.EntityFilter;
import com.qr.qradmin.generic.GenericDtoService;
import com.qr.qradmin.generic.GenericEntityService;
import com.qr.qradmin.service.entity.TerminalService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import ru.qrhandshake.qrpos.domain.Terminal;
import ru.qrhandshake.qrpos.domain.User;
import ru.qrhandshake.qrpos.util.SecurityUtils;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class TerminalDtoService extends GenericDtoService<Terminal, TerminalDto> {

    private final static Logger logger = LoggerFactory.getLogger(TerminalDtoService.class);

    @Resource
    private TerminalService terminalService;

    @Override
    protected EntityFilter buildFilter(Map<String, String> filter) {
        TerminalFilter entityFilter = new TerminalFilter();
        if (!SecurityUtils.isCurrentUserAdmin()) {          //TODO сделать отдельный метод для получения своих записей
            User user = SecurityUtils.getCurrentUser();
            logger.trace("Current user: [{}], authorities: [{}]",user.getUsername(), user.getAuthorities());
            Set<Terminal> terminals = terminalService.findByMerchant(user.getMerchant());
            if ( terminals.isEmpty() ) {
                entityFilter.setTerminalIds(Arrays.asList(null));
            }
            else {
                List<Long> merchantTerminalIds = terminals.stream()
                        .map(Terminal::getId)
                        .collect(Collectors.toList());
                logger.trace("Terminals: {}", merchantTerminalIds);
                entityFilter.setTerminalIds(merchantTerminalIds);
            }
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
