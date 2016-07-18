package com.qr.qradmin.service.entity;

import com.qr.qradmin.dao.MerchantOrderRepository;
import com.qr.qradmin.generic.EntityFilter;
import com.qr.qradmin.generic.GenericEntityService;
import com.qr.qradmin.generic.GenericRepository;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import ru.qrhandshake.qrpos.domain.MerchantOrder;

import javax.annotation.Resource;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

@Service
public class MerchantOrderService extends GenericEntityService<MerchantOrder> {

    @Resource
    private MerchantOrderRepository merchantOrderRepository;

    @Override
    protected Specification<MerchantOrder> buildSpecification(final EntityFilter filter) {
        final Specification<MerchantOrder> specification = new Specification<MerchantOrder>() {
            @Override
            public Predicate toPredicate(Root<MerchantOrder> root, CriteriaQuery<?> cq, CriteriaBuilder cb) {
                Predicate predicate = buildPredicate(root, cb, filter);
                return predicate;
            }
        };
        return specification;
    }

    @Override
    protected GenericRepository<MerchantOrder> getRepository() {
        return merchantOrderRepository;
    }
}
