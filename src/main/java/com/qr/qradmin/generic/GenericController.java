package com.qr.qradmin.generic;

import com.qr.qradmin.enums.ErrorCode;
import com.qr.qradmin.service.ErrorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.*;
import ru.qrhandshake.qrpos.domain.EnumGrantedAuthority;
import ru.qrhandshake.qrpos.util.SecurityUtils;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class GenericController<E, EDto> {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    protected final Map<CrudOperation, List<EnumGrantedAuthority>> supportedOperations = new HashMap<>();

    protected abstract Validator getEntityValidator();

    protected abstract Validator getFilterValidator();

    protected abstract GenericDtoService<E, EDto> getDtoService();

    @Resource
    private ErrorService errorService;
    @Resource
    private GenericPageableFilterDtoValidator genericPageableFilterDtoValidator;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    @Transactional
    public Response get(@PathVariable Long id) {
        checkForSupportedOperations(CrudOperation.GET_ONE);
        return getDtoService().get(id);
    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    @Transactional
    public Response get(PageableFilterDto pageableFilter, BindingResult result) throws BindException {
        checkForSupportedOperations(CrudOperation.GET_SEVERAL);
        genericPageableFilterDtoValidator.validate(pageableFilter, result);
        getFilterValidator().validate(pageableFilter, result);
        if (result.hasErrors()) {
            return errorService.generateErrorResponse(result);
        }
        return getDtoService().get(pageableFilter);
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    @Transactional
    public Response create(@RequestBody EDto dto, BindingResult result) {
        checkForSupportedOperations(CrudOperation.CREATE);
        getEntityValidator().validate(dto, result);
        if (result.hasErrors()) {
            return errorService.generateErrorResponse(result);
        }
        return getDtoService().create(dto);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ResponseBody
    @Transactional
    public Response update(@PathVariable Long id, @RequestBody EDto dto, BindingResult result) {
        checkForSupportedOperations(CrudOperation.UPDATE);
        getEntityValidator().validate(dto, result);
        if (result.hasErrors()) {
            return errorService.generateErrorResponse(result);
        }
        return getDtoService().update(id, dto);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    @Transactional
    public Response delete(@PathVariable Long id, BindingResult result) {
        checkForSupportedOperations(CrudOperation.DELETE);
        if (result.hasErrors()) {
            return errorService.generateErrorResponse(result);
        }
        return getDtoService().delete(id);
    }

    private void checkForSupportedOperations(CrudOperation operation) {
        if (!supportedOperations.containsKey(operation)) {
            throw new GeneralException(ErrorCode.UNSUPPORTED_OPERATION);
        }
        if (!supportedOperations.get(operation).isEmpty() &&
                Collections.disjoint(
                        supportedOperations.get(operation),
                        SecurityUtils.getCurrentUser().getAuthorities())
                ) {
            throw new GeneralException(ErrorCode.ACCESS_DENIED);
        }
    }
}
