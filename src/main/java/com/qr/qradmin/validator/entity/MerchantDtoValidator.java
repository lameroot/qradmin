package com.qr.qradmin.validator.entity;

import com.qr.qradmin.dao.MerchantRepository;
import com.qr.qradmin.dto.entity.MerchantDto;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ru.qrhandshake.qrpos.domain.Merchant;

import javax.annotation.Resource;

@Service
public class MerchantDtoValidator implements Validator {

    @Resource
    private MerchantRepository merchantRepository;

    @Override
    public boolean supports(Class<?> clazz) {
        return MerchantDto.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        MerchantDto merchantDto = (MerchantDto)target;
        Merchant merchant = merchantRepository.findByName(merchantDto.getName());
        if ( null != merchant ) {
            errors.reject("MerchantDto.name.NotUnique", null, null);
        }
    }
}
