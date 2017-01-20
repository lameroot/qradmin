package com.qr.qradmin.validator.filter;

import com.qr.qradmin.dto.filter.MerchantFilterDto;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Service
public class MerchantFilterDtoValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return MerchantFilterDto.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
    }
}
