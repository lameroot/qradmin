package com.qr.qradmin.validator.entity;

import com.qr.qradmin.dto.entity.UserDto;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ru.qrhandshake.qrpos.domain.User;

@Service
public class UserDtoValidator implements Validator{

    @Override
    public boolean supports(Class<?> clazz) {
        return  UserDto.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
