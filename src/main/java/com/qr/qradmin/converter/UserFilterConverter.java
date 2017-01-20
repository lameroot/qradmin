package com.qr.qradmin.converter;

import com.qr.qradmin.dto.filter.UserFilterDto;
import com.qr.qradmin.filter.UserFilter;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class UserFilterConverter implements Converter<UserFilterDto, UserFilter> {

    @Override
    public UserFilter convert(UserFilterDto filterDto) {
        if (filterDto == null) return null;
        UserFilter filter = new UserFilter();
        return filter;
    }
}
