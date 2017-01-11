package com.qr.qradmin.generic;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qr.qradmin.model.Filter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.convert.ConversionService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.Transactional;
import ru.qrhandshake.qrpos.util.SecurityUtils;

import javax.annotation.Resource;
import java.util.*;

public abstract class GenericDtoService<E, EDto, EFilterDto> {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    protected List nullList = new ArrayList(){{
        add(null);
    }};

    @Resource
    protected ConversionService conversionService;
    @Resource
    protected ObjectMapper objectMapper;

    protected abstract EntityFilter buildFilter(EFilterDto filter);//TODO переделать на конвертер!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

    protected abstract Class<E> getEClass();

    protected abstract Class<EDto> getEDtoClass();

    protected abstract GenericEntityService<E> getEntityService();

    @Transactional
    public ElementResponse<EDto> get(Long id) {
        return new ElementResponse<>(conversionService.convert(getEntityService().get(id), getEDtoClass()));
    }

    @Transactional
    public PageResponse<EDto> get(PageableFilterDto<EFilterDto> pagebleFilterDto) {
        Sort sort = Optional
                .ofNullable(pagebleFilterDto.getSort())
                .orElse(new Sort(Sort.Direction.DESC, "id"));
        PageRequest pageRequest = new PageRequest(pagebleFilterDto.getPage() - 1, pagebleFilterDto.getLimit(), sort);
        EntityFilter filter = buildFilter(pagebleFilterDto.getFilter());
        Page<E> entityPage = getEntityService().get(filter, pageRequest);
        List<EDto> dtos = new LinkedList<>();
        for (E e : entityPage) {
            EDto eDto = conversionService.convert(e, getEDtoClass());
            if ( null != eDto ) dtos.add(eDto);
        }
        return new PageResponse<>(dtos, entityPage.getTotalElements());
    }

    @Transactional
    public ElementResponse<EDto> create(EDto dto) {
        logger.trace("Create : {} by {}",dto, SecurityUtils.getCurrentUser());
        E e = conversionService.convert(dto, getEClass());
        return new ElementResponse<>(conversionService.convert(getEntityService().create(e), getEDtoClass()));
    }

    @Transactional
    public ElementResponse<EDto> update(Long id, EDto dto) {
        logger.trace("Update : {} by {}",dto, SecurityUtils.getCurrentUser());
        E e = conversionService.convert(dto, getEClass());
        return new ElementResponse<>(conversionService.convert(getEntityService().update(id, e), getEDtoClass()));
    }

    @Transactional
    public Response delete(Long id) {
        logger.trace("Delete : {} by {}",id, SecurityUtils.getCurrentUser());
        getEntityService().delete(id);
        return Response.SUCCESSFUL;
    }
}
