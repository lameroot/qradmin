package com.qr.qradmin.generic;

import com.qr.qradmin.enums.ErrorCode;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Service
public class GenericPageableFilterDtoValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return PageableFilterDto.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        PageableFilterDto t = (PageableFilterDto) target;
        if (t.getLimit() == null) {
            errors.rejectValue("limit", ErrorCode.VALIDATION_FAILED.getCode(), null, "filter.limit.empty");       //TODO format ErrorCode.VALIDATION_FAILED.getMessage()
        }
        if (t.getPage() == null) {
            errors.rejectValue("page", ErrorCode.VALIDATION_FAILED.getCode(), null, "filter.page.zero");        //TODO format ErrorCode.VALIDATION_FAILED.getMessage()
        }
    }
}
