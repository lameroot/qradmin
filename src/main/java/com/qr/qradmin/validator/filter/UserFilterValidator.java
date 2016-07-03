package com.qr.qradmin.validator.filter;

import com.qr.qradmin.filter.UserFilter;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Service
public class UserFilterValidator implements Validator{

    @Override
    public boolean supports(Class<?> clazz) {
        return UserFilter.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
    }
}
