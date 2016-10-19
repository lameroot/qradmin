package com.qr.qradmin.validator.entity;

import com.qr.qradmin.dto.entity.MerchantDto;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Service
public class MerchantDtoValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return MerchantDto.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
