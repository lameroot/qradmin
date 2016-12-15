package com.qr.qradmin.validator.entity;

import com.qr.qradmin.dao.UserRepository;
import com.qr.qradmin.dto.entity.UserDto;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ru.qrhandshake.qrpos.domain.User;

import javax.annotation.Resource;

@Service
public class UserDtoValidator implements Validator {

    @Resource
    private UserRepository userRepository;

    @Override
    public boolean supports(Class<?> clazz) {
        return UserDto.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        UserDto userDto = (UserDto)target;
        User user = userRepository.findByUsername(userDto.getUserName());
        if ( null != user ) {
            errors.reject("UserDto.name.NotUnique", null, null);
        }
    }
}
