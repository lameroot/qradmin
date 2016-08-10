package com.qr.qradmin.service.entity;

import com.qr.qradmin.dao.TerminalRepository;
import com.qr.qradmin.filter.OrderTemplateFilter;
import com.qr.qradmin.generic.EntityFilter;
import com.qr.qradmin.generic.GenericEntityService;
import com.qr.qradmin.generic.GenericRepository;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import ru.qrhandshake.qrpos.domain.Terminal;

import javax.annotation.Resource;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

@Service
public class TerminalService extends GenericEntityService<Terminal> {

    @Resource
    private TerminalRepository terminalRepository;

    @Override
    protected Specification<Terminal> buildSpecification(final EntityFilter f) {
        final Specification<Terminal> specification = new Specification<Terminal>() {
            @Override
            public Predicate toPredicate(Root<Terminal> root, CriteriaQuery<?> cq, CriteriaBuilder cb) {
                OrderTemplateFilter filter = (OrderTemplateFilter) f;
                Predicate predicate = buildPredicate(root, cb, filter);

                return predicate;
            }
        };
        return specification;
    }

    @Override
    protected GenericRepository<Terminal> getRepository() {
        return terminalRepository;
    }
}
