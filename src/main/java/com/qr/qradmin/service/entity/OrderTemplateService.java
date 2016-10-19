package com.qr.qradmin.service.entity;

import com.qr.qradmin.dao.OrderTemplateRepository;
import com.qr.qradmin.filter.OrderTemplateFilter;
import com.qr.qradmin.generic.EntityFilter;
import com.qr.qradmin.generic.GenericEntityService;
import com.qr.qradmin.generic.GenericRepository;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import ru.qrhandshake.qrpos.domain.OrderTemplate;
import ru.qrhandshake.qrpos.domain.OrderTemplate_;

import javax.annotation.Resource;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

@Service
public class OrderTemplateService extends GenericEntityService<OrderTemplate> {

    @Resource
    private OrderTemplateRepository orderTemplateRepository;

    @Override
    protected Specification<OrderTemplate> buildSpecification(final EntityFilter f) {
        final Specification<OrderTemplate> specification = new Specification<OrderTemplate>() {
            @Override
            public Predicate toPredicate(Root<OrderTemplate> root, CriteriaQuery<?> cq, CriteriaBuilder cb) {
                OrderTemplateFilter filter = (OrderTemplateFilter) f;
                Predicate predicate = buildPredicate(root, cb, filter);

                if (filter.getAmountFrom() != null) {
                    predicate.getExpressions().add(cb.greaterThanOrEqualTo(root.get(OrderTemplate_.amount), filter.getAmountFrom()));
                }
                if (filter.getAmountTo() != null) {
                    predicate.getExpressions().add(cb.lessThanOrEqualTo(root.get(OrderTemplate_.amount), filter.getAmountTo()));
                }

                if (!CollectionUtils.isEmpty(filter.getTerminalIds())) {
                    predicate.getExpressions().add(root.get(OrderTemplate_.terminal).in(filter.getTerminalIds()));
                }

                if (filter.getName() != null) {
                    predicate.getExpressions().add(cb.equal(root.get(OrderTemplate_.name), filter.getName()));
                }

                return predicate;
            }
        };
        return specification;
    }

    @Override
    protected GenericRepository<OrderTemplate> getRepository() {
        return orderTemplateRepository;
    }
}
