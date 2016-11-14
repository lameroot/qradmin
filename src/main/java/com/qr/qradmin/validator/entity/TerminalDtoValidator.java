package com.qr.qradmin.validator.entity;

import com.qr.qradmin.dto.entity.MerchantDto;
import com.qr.qradmin.dto.entity.TerminalDto;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Service
public class TerminalDtoValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return TerminalDto.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
