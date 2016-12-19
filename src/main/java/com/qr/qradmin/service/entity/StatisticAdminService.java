package com.qr.qradmin.service.entity;

import com.qr.qradmin.dao.StatisticAdminRepository;
import com.qr.qradmin.filter.StatisticFilter;
import com.qr.qradmin.generic.EntityFilter;
import com.qr.qradmin.generic.GenericEntityService;
import com.qr.qradmin.generic.GenericRepository;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import ru.qrhandshake.qrpos.domain.Statistic;
import ru.qrhandshake.qrpos.domain.Statistic_;
import ru.qrhandshake.qrpos.service.stats.StatisticService;

import javax.annotation.Resource;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

@Service
public class StatisticAdminService extends GenericEntityService<Statistic> {

    @Resource
    private StatisticAdminRepository statisticAdminRepository;
    @Resource
    private StatisticService statisticService;

    @Override
    protected Specification<Statistic> buildSpecification(EntityFilter filter) {
        Specification<Statistic> specification = new Specification<Statistic>() {
            @Override
            public Predicate toPredicate(Root<Statistic> root, CriteriaQuery<?> cq, CriteriaBuilder cb) {
                StatisticFilter statisticFilter = (StatisticFilter)filter;
                Predicate predicate = buildPredicate(root, cb, statisticFilter);

                if ( null != statisticFilter.getMerchantId() ) {
                    predicate.getExpressions().add(cb.equal(root.get(Statistic_.merchantId), statisticFilter.getMerchantId()));
                }
                if ( null != statisticFilter.getBefore() && null != statisticFilter.getTimeSlot() ) {
                    List<StatisticFilter.Slot> slots = statisticFilter.getTimeSlot().getSlots(statisticFilter.getBefore());
                    slots.stream().forEach(slot -> {
                        //predicate.getExpressions().add(cb.between(root.get(Statistic_.startTime), slot.getStartTime()))
                    });
                }

                return null;
            }
        };
        return specification;
    }



    @Override
    protected GenericRepository<Statistic> getRepository() {
        return statisticAdminRepository;
    }
}
