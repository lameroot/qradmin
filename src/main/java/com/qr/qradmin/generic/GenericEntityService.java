package com.qr.qradmin.generic;

import com.qr.qradmin.enums.ErrorCode;
import com.qr.qradmin.utils.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 * Created by Smirnov_Y on 18.06.2015.
 */
public abstract class GenericEntityService<E> {

    public E get(Long id) {
        E e = getRepository().findOne(id);
        if (e == null) throw new GeneralException(ErrorCode.ELEMENT_NOT_FOUND, id);
        return e;
    }

    public Page<E> get(EntityFilter filter, PageRequest pageRequest) {
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
        getRepository().save(target);
        return target;
    }

    public E update(E source) {
        return getRepository().save(source);
    }

    public void delete(Long id) {
        throw new UnsupportedOperationException();
    }

    protected abstract Specification<E> buildSpecification(EntityFilter filter);

    protected abstract GenericRepository<E> getRepository();

    protected E fillDefaultFields(E e) {
        return e;
    }

    ;

    protected Predicate buildPredicate(Root root, CriteriaBuilder cb, EntityFilter filter) {
        Predicate predicate = cb.conjunction();
        if (filter.getFromId() != null) {
            predicate.getExpressions().add(cb.lt(root.<Long>get("id"), filter.getFromId()));
        }
        return predicate;
    }
}
