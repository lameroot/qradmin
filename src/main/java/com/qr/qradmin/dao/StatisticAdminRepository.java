package com.qr.qradmin.dao;

import com.qr.qradmin.generic.GenericRepository;
import org.springframework.stereotype.Repository;
import ru.qrhandshake.qrpos.domain.Statistic;

@Repository
public interface StatisticAdminRepository extends GenericRepository<Statistic> {
}
