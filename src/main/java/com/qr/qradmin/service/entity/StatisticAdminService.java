package com.qr.qradmin.service.entity;

import com.qr.qradmin.generic.EntityFilter;
import com.qr.qradmin.generic.GenericEntityService;
import com.qr.qradmin.generic.GenericRepository;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import ru.qrhandshake.qrpos.domain.Statistic;

@Service
public class StatisticAdminService extends GenericEntityService<Statistic> {

    @Override
    protected Specification<Statistic> buildSpecification(EntityFilter filter) {
        return null;
    }

    @Override
    protected GenericRepository<Statistic> getRepository() {
        return null;
    }
}
