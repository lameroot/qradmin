package com.qr.qradmin.generic;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qr.qradmin.model.Filter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.convert.ConversionService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import ru.qrhandshake.qrpos.util.SecurityUtils;

import javax.annotation.Resource;
import java.util.*;

public abstract class GenericDtoService<E, EDto> {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    protected List nullList = new ArrayList(){{
        add(null);
    }};

    @Resource
    protected ConversionService conversionService;
    @Resource
    protected ObjectMapper objectMapper;

    protected abstract EntityFilter buildFilter(Map<String, String> filter);

    protected abstract Class<E> getEClass();

    protected abstract Class<EDto> getEDtoClass();

    protected abstract GenericEntityService<E> getEntityService();

    public ElementResponse<EDto> get(Long id) {
        return new ElementResponse(conversionService.convert(getEntityService().get(id), getEDtoClass()));
    }

    public PageResponse get(PageableFilterDto filterDto) {
        Sort sort = Optional
                .ofNullable(filterDto.getSort())
                .orElse(new Sort(Sort.Direction.DESC, "id"));
        PageRequest pageRequest = new PageRequest(filterDto.getPage() - 1, filterDto.getLimit(), sort);
        Map<String, String> filter = Optional.ofNullable(filterDto.getFilter()).map(Filter::getFilters).orElse(null);
        Page<E> entityPage = getEntityService().get(buildFilter(filter), pageRequest);
        List<EDto> dtos = new LinkedList<>();
        for (E e : entityPage) {
            EDto eDto = conversionService.convert(e, getEDtoClass());
            if ( null != eDto ) dtos.add(eDto);
        }
        return new PageResponse(dtos, entityPage.getTotalElements());
    }


    public Response create(EDto dto) {
        logger.trace("Create : {} by {}",dto, SecurityUtils.getCurrentUser());
        E e = conversionService.convert(dto, getEClass());
        return new ElementResponse(conversionService.convert(getEntityService().create(e), getEDtoClass()));
    }

    public Response update(Long id, EDto dto) {
        logger.trace("Update : {} by {}",dto, SecurityUtils.getCurrentUser());
        E e = conversionService.convert(dto, getEClass());
        return new ElementResponse(conversionService.convert(getEntityService().update(id, e), getEDtoClass()));
    }

    public Response delete(Long id) {
        logger.trace("Delete : {} by {}",id, SecurityUtils.getCurrentUser());
        getEntityService().delete(id);
        return Response.SUCCESSFUL;
    }
}
