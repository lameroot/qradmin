package com.qr.qradmin.validator.filter;

import com.qr.qradmin.dto.filter.MerchantOrderFilterDto;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Service
public class MerchantOrderFilterDtoValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return MerchantOrderFilterDto.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
    }
}
