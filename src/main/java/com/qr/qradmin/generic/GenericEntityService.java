package com.qr.qradmin.generic;

import com.qr.qradmin.enums.ErrorCode;
import com.qr.qradmin.utils.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public abstract class GenericEntityService<E, EFilter> {

    public E get(Long id) {
        E e = getRepository().findOne(id);
        if (e == null) throw new GeneralException(ErrorCode.ELEMENT_NOT_FOUND, id, getClass());
        return e;
    }

    public Page<E> get(EFilter filter, PageRequest pageRequest) {
        return getRepository().findAll(buildSpecification(filter), pageRequest);
    }

    public E create(E e) {
        return getRepository().save(fillDefaultFields(e));
    }

    public E update(Long id, E source) {
        if (id == null) return null;
        E target = getRepository().findOne(id);
        if (target == null) return null;
        BeanUtils.updateBean(source, target);
        return getRepository().save(target);
    }

    public E update(E source) {
        return getRepository().save(source);
    }

    public void delete(Long id) {
        throw new UnsupportedOperationException();
    }

    protected abstract Specification<E> buildSpecification(EFilter filter);

    protected abstract GenericRepository<E> getRepository();

    protected E fillDefaultFields(E e) {
        return e;
    }

    protected Predicate buildPredicate(Root root, CriteriaBuilder cb, EFilter filter) {
        Predicate predicate = cb.conjunction();
        return predicate;
    }
}
