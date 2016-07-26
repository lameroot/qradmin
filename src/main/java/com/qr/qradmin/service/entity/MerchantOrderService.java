package com.qr.qradmin.service.entity;

import com.qr.qradmin.dao.MerchantOrderRepository;
import com.qr.qradmin.filter.MerchantOrderFilter;
import com.qr.qradmin.generic.EntityFilter;
import com.qr.qradmin.generic.GenericEntityService;
import com.qr.qradmin.generic.GenericRepository;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import ru.qrhandshake.qrpos.domain.*;

import javax.annotation.Resource;
import javax.persistence.criteria.*;
import java.util.Date;
import java.util.List;

@Service
public class MerchantOrderService extends GenericEntityService<MerchantOrder> {

    @Resource
    private MerchantOrderRepository merchantOrderRepository;

    @Override
    protected Specification<MerchantOrder> buildSpecification(final EntityFilter f) {
        final Specification<MerchantOrder> specification = new Specification<MerchantOrder>() {
            @Override
            public Predicate toPredicate(Root<MerchantOrder> root, CriteriaQuery<?> cq, CriteriaBuilder cb) {
                MerchantOrderFilter filter = (MerchantOrderFilter)f;
                Predicate predicate = buildPredicate(root, cb, filter);

//                if (filter.getId() != null) {
//                    predicate.getExpressions().add( cb.greaterThanOrEqualTo(root.get(MerchantOrder_.createdAt), filter.getCreatedAtFrom()) );
//                }
//                if (filter.getOrderId() != null) {
//                    predicate.getExpressions().add( cb.greaterThanOrEqualTo(root.get(MerchantOrder_.createdAt), filter.getCreatedAtFrom()) );
//                }
//                if (filter.getExternalId() != null) {
//                    predicate.getExpressions().add( cb.greaterThanOrEqualTo(root.get(MerchantOrder_.createdAt), filter.getCreatedAtFrom()) );
//                }
//                if (filter.getExternalOrderStatus() != null) {
//                    predicate.getExpressions().add( cb.greaterThanOrEqualTo(root.get(MerchantOrder_.createdAt), filter.getCreatedAtFrom()) );
//                }
//                if (filter.getCreatedDateFrom() != null) {
//                    predicate.getExpressions().add( cb.greaterThanOrEqualTo(root.get(MerchantOrder_.createdAt), filter.getCreatedAtFrom()) );
//                }
//                if (filter.getCreatedDateTo() != null) {
//                    predicate.getExpressions().add( cb.greaterThanOrEqualTo(root.get(MerchantOrder_.createdAt), filter.getCreatedAtFrom()) );
//                }
//                if (filter.getPaymentDateFrom() != null) {
//                    predicate.getExpressions().add( cb.greaterThanOrEqualTo(root.get(MerchantOrder_.createdAt), filter.getCreatedAtFrom()) );
//                }
//                if (filter.getPaymentDateTo() != null) {
//                    predicate.getExpressions().add( cb.greaterThanOrEqualTo(root.get(MerchantOrder_.createdAt), filter.getCreatedAtFrom()) );
//                }
//                if (filter.getAmountFrom() != null) {
//                    predicate.getExpressions().add( cb.greaterThanOrEqualTo(root.get(MerchantOrder_.createdAt), filter.getCreatedAtFrom()) );
//                }
//                if (filter.getAmountTo() != null) {
//                    predicate.getExpressions().add( cb.greaterThanOrEqualTo(root.get(MerchantOrder_.createdAt), filter.getCreatedAtFrom()) );
//                }
//                if (filter.getDeviceId() != null) {
//                    predicate.getExpressions().add( cb.greaterThanOrEqualTo(root.get(MerchantOrder_.createdAt), filter.getCreatedAtFrom()) );
//                }
//                if (filter.getMerchantId() != null) {
//                    predicate.getExpressions().add( cb.greaterThanOrEqualTo(root.get(MerchantOrder_.createdAt), filter.getCreatedAtFrom()) );
//                }
//                if (filter.getTerminalId() != null) {
//                    predicate.getExpressions().add( cb.greaterThanOrEqualTo(root.get(MerchantOrder_.createdAt), filter.getCreatedAtFrom()) );
//                }
//                if (filter.getClientId() != null) {
//                    predicate.getExpressions().add( cb.greaterThanOrEqualTo(root.get(MerchantOrder_.createdAt), filter.getCreatedAtFrom()) );
//                }
//                if (filter.getSessionId() != null) {
//                    predicate.getExpressions().add( cb.greaterThanOrEqualTo(root.get(MerchantOrder_.createdAt), filter.getCreatedAtFrom()) );
//                }
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
