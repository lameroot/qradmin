package com.qr.qradmin.dao;

import com.qr.qradmin.generic.GenericRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.qrhandshake.qrpos.domain.Statistic;

@Repository
public interface StatisticAdminRepository extends GenericRepository<Statistic> {

    @Query("select sum(s.value) from Statistic s where s.type = :type and s.merchantId = :merchantId and s.startTime <= :start and s.endTime > :finish")
    Long sumByPeriod(@Param("type")Statistic.StatisticType type, @Param("merchantId")Long merchantId, @Param("start")Long start, @Param("finish")Long finish);

    @Query("select sum(s.value) from Statistic s where s.type = :type and s.merchantId = :merchantId and s.orderTemplateId in :orderTemplateIds and s.startTime <= :start and s.endTime > :finish")
    Long sumByPeriod(@Param("type")Statistic.StatisticType type, @Param("merchantId")Long merchantId, @Param("orderTemplateIds")Long[] orderTemplateIds, @Param("start")Long start, @Param("finish")Long finish);
}
