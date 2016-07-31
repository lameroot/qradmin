package com.qr.qradmin.service.entity;

import com.qr.qradmin.dao.MerchantOrderRepository;
import com.qr.qradmin.filter.MerchantOrderFilter;
import com.qr.qradmin.generic.EntityFilter;
import com.qr.qradmin.generic.GenericEntityService;
import com.qr.qradmin.generic.GenericRepository;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import ru.qrhandshake.qrpos.domain.MerchantOrder;
import ru.qrhandshake.qrpos.domain.MerchantOrder_;

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
    protected Specification<MerchantOrder> buildSpecification(final EntityFilter f) {
        final Specification<MerchantOrder> specification = new Specification<MerchantOrder>() {
            @Override
            public Predicate toPredicate(Root<MerchantOrder> root, CriteriaQuery<?> cq, CriteriaBuilder cb) {
                MerchantOrderFilter filter = (MerchantOrderFilter) f;
                Predicate predicate = buildPredicate(root, cb, filter);

                if (filter.getId() != null) {
                    predicate.getExpressions().add(cb.equal(root.get(MerchantOrder_.id), filter.getId()));
                }
                if (filter.getOrderId() != null) {
                    predicate.getExpressions().add(cb.equal(root.get(MerchantOrder_.orderId), filter.getOrderId()));
                }
                if (filter.getExternalId() != null) {
                    predicate.getExpressions().add(cb.equal(root.get(MerchantOrder_.externalId), filter.getExternalId()));
                }
                if (filter.getExternalOrderStatus() != null) {
                    predicate.getExpressions().add(cb.equal(root.get(MerchantOrder_.externalOrderStatus), filter.getExternalOrderStatus()));
                }

                if (filter.getCreatedDateFrom() != null) {
                    predicate.getExpressions().add(cb.greaterThanOrEqualTo(root.get(MerchantOrder_.createdDate), filter.getCreatedDateFrom()));
                }
                if (filter.getCreatedDateTo() != null) {
                    predicate.getExpressions().add(cb.lessThanOrEqualTo(root.get(MerchantOrder_.createdDate), filter.getCreatedDateTo()));
                }

                if (filter.getPaymentDateFrom() != null) {
                    predicate.getExpressions().add(cb.greaterThanOrEqualTo(root.get(MerchantOrder_.paymentDate), filter.getPaymentDateFrom()));
                }
                if (filter.getPaymentDateTo() != null) {
                    predicate.getExpressions().add(cb.lessThanOrEqualTo(root.get(MerchantOrder_.paymentDate), filter.getPaymentDateTo()));
                }

                if (filter.getAmountFrom() != null) {
                    predicate.getExpressions().add(cb.greaterThanOrEqualTo(root.get(MerchantOrder_.amount), filter.getAmountFrom()));
                }
                if (filter.getAmountTo() != null) {
                    predicate.getExpressions().add(cb.lessThanOrEqualTo(root.get(MerchantOrder_.amount), filter.getAmountTo()));
                }

                if (filter.getDeviceId() != null) {
                    predicate.getExpressions().add(cb.equal(root.get(MerchantOrder_.deviceId), filter.getDeviceId()));
                }
                if (filter.getMerchantId() != null) {
                    predicate.getExpressions().add(cb.equal(root.get(MerchantOrder_.merchant), filter.getMerchantId()));
                }
                if (filter.getTerminalId() != null) {
                    predicate.getExpressions().add(cb.equal(root.get(MerchantOrder_.terminal), filter.getTerminalId()));
                }
                if (filter.getClientId() != null) {
                    predicate.getExpressions().add(cb.equal(root.get(MerchantOrder_.client), filter.getClientId()));
                }
                if (filter.getSessionId() != null) {
                    predicate.getExpressions().add(cb.equal(root.get(MerchantOrder_.sessionId), filter.getSessionId()));
                }
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
