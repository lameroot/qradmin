package com.qr.qradmin.validator.entity;

import com.qr.qradmin.dto.entity.OrderTemplateDto;
import com.qr.qradmin.service.entity.UserService;
import org.hibernate.Hibernate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ru.qrhandshake.qrpos.domain.Terminal;
import ru.qrhandshake.qrpos.domain.User;
import ru.qrhandshake.qrpos.service.TerminalService;
import ru.qrhandshake.qrpos.util.SecurityUtils;

import javax.annotation.Resource;
import java.util.Objects;
import java.util.Set;

@Service
public class OrderTemplateDtoValidator implements Validator {

    @Resource
    private UserService userService;
    @Resource
    private TerminalService terminalService;

    @Override
    public boolean supports(Class<?> clazz) {
        return OrderTemplateDto.class.isAssignableFrom(clazz);
    }

    @Override
    @Transactional(readOnly = true)
    public void validate(Object target, Errors errors) {
        OrderTemplateDto orderTemplateDto = (OrderTemplateDto) target;
        User user = userService.get(SecurityUtils.getCurrentUser().getId());
        Hibernate.initialize(user.getMerchant());
        Set<Terminal> terminals = terminalService.findByMerchant(user.getMerchant());
        //Hibernate.initialize(terminals);
        if (!SecurityUtils.isCurrentUserAdmin() && orderTemplateDto.getTerminalId() != null &&
                !terminals
                        .stream()
                        .anyMatch(terminal -> Objects.equals(terminal.getId(), orderTemplateDto.getTerminalId()))

                ) {
            errors.reject("OrderTemplateDto.terminalId.NotFound", null, null);
        }
    }
}
