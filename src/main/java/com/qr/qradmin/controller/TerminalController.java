package com.qr.qradmin.controller;

import com.qr.qradmin.dto.entity.TerminalDto;
import com.qr.qradmin.dto.filter.TerminalFilterDto;
import com.qr.qradmin.generic.CrudOperation;
import com.qr.qradmin.generic.GenericController;
import com.qr.qradmin.generic.GenericDtoService;
import com.qr.qradmin.service.dto.TerminalDtoService;
import com.qr.qradmin.validator.entity.TerminalDtoValidator;
import com.qr.qradmin.validator.filter.TerminalFilterDtoValidator;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.qrhandshake.qrpos.domain.EnumGrantedAuthority;
import ru.qrhandshake.qrpos.domain.Terminal;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.Collections;

@Controller
@RequestMapping("/api/terminal")
public class TerminalController extends GenericController<Terminal, TerminalDto, TerminalFilterDto> {

    @PostConstruct
    public void init() {
        supportedOperations.put(CrudOperation.GET_ONE, Collections.singletonList(EnumGrantedAuthority.ADMIN));
        supportedOperations.put(CrudOperation.GET_SEVERAL, Collections.emptyList());        //TODO сделать отдельный метод для получения своих записей
        supportedOperations.put(CrudOperation.CREATE, Collections.singletonList(EnumGrantedAuthority.ADMIN));
        supportedOperations.put(CrudOperation.UPDATE, Collections.singletonList(EnumGrantedAuthority.ADMIN));
    }

    @Resource
    private TerminalDtoService terminalDtoService;
    @Resource
    private TerminalDtoValidator terminalDtoValidator;
    @Resource
    private TerminalFilterDtoValidator terminalFilterDtoValidator;

    @Override
    protected Validator getEntityValidator() {
        return terminalDtoValidator;
    }

    @Override
    protected Validator getFilterValidator() {
        return terminalFilterDtoValidator;
    }

    @Override
    protected GenericDtoService<Terminal, TerminalDto, TerminalFilterDto> getDtoService() {
        return terminalDtoService;
    }
}
