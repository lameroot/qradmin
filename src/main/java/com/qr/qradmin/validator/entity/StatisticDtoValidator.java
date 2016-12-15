package com.qr.qradmin.validator.entity;

import com.qr.qradmin.dto.entity.StatisticDto;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Service
public class StatisticDtoValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return StatisticDto.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
