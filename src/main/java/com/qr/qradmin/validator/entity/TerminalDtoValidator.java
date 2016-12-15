package com.qr.qradmin.validator.entity;

import com.qr.qradmin.dao.TerminalRepository;
import com.qr.qradmin.dto.entity.TerminalDto;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ru.qrhandshake.qrpos.domain.Terminal;

import javax.annotation.Resource;

@Service
public class TerminalDtoValidator implements Validator {

    @Resource
    private TerminalRepository terminalRepository;

    @Override
    public boolean supports(Class<?> clazz) {
        return TerminalDto.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        TerminalDto terminalDto = (TerminalDto)target;
        Terminal terminal = terminalRepository.findByAuthName(terminalDto.getAuthName());
        if ( null != terminal ) {
            errors.reject("TerminalDto.name.NotUnique", null, null);
            return;
        }
        if ( StringUtils.isBlank(terminalDto.getAuthName()) || StringUtils.isBlank(terminalDto.getAuthPassword()) ) {
            errors.reject("TerminalDto.auth.invalid", null, null);
            return;
        }
    }
}
