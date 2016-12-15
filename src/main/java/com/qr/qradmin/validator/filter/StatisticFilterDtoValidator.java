package com.qr.qradmin.validator.filter;

import com.qr.qradmin.dto.filter.StatisticFilterDto;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Service
public class StatisticFilterDtoValidator implements Validator{

    @Override
    public boolean supports(Class<?> clazz) {
        return StatisticFilterDto.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
