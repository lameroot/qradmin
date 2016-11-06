package com.qr.qradmin.service.entity;

import com.qr.qradmin.dao.MerchantRepository;
import com.qr.qradmin.generic.EntityFilter;
import com.qr.qradmin.generic.GenericEntityService;
import com.qr.qradmin.generic.GenericRepository;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import ru.qrhandshake.qrpos.domain.Merchant;

import javax.annotation.Resource;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

@Service
public class MerchantService extends GenericEntityService<Merchant> {

    @Resource
    private MerchantRepository merchantRepository;

    @Override
    protected Specification<Merchant> buildSpecification(final EntityFilter filter) {
        final Specification<Merchant> specification = new Specification<Merchant>() {
            @Override
            public Predicate toPredicate(Root<Merchant> root, CriteriaQuery<?> cq, CriteriaBuilder cb) {
                Predicate predicate = buildPredicate(root, cb, filter);
                return predicate;
            }
        };
        return specification;
    }

    @Override
    protected GenericRepository<Merchant> getRepository() {
        return merchantRepository;
    }
}
