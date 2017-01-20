package com.qr.qradmin.service.entity;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.qr.qradmin.dao.StatisticAdminRepository;
import com.qr.qradmin.filter.StatisticFilter;
import com.qr.qradmin.model.StatisticPoint;
import org.springframework.stereotype.Service;
import ru.qrhandshake.qrpos.domain.Statistic;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class StatisticAdminService  {

    @Resource
    private StatisticAdminRepository statisticAdminRepository;

    public Long sumByPeriod(Statistic.StatisticType type, Date startTime, Date endTime, Long merchantId, Long... orderTemplateIds ) {
        return null == orderTemplateIds || 0 == orderTemplateIds.length
                ? statisticAdminRepository.sumByPeriod(type, merchantId, endTime.getTime(), startTime.getTime())
                : statisticAdminRepository.sumByPeriod(type, merchantId, orderTemplateIds, endTime.getTime(), startTime.getTime());
    }

    public List<StatisticPoint> get(StatisticFilter filter) {
        StatisticPoint point1 = new StatisticPoint();
        point1.setX("Jan");
        point1.setY(ImmutableMap.of(
                1L, 7L,
                3L, 9L,
                5L, 1L
        ));

        StatisticPoint point2 = new StatisticPoint();
        point2.setX("Feb");
        point2.setY(ImmutableMap.of(
                1L, 4L,
                3L, 2L,
                5L, 7L
        ));

        StatisticPoint point3 = new StatisticPoint();
        point3.setX("Mar");
        point3.setY(ImmutableMap.of(
                1L, 8L,
                3L, 3L,
                5L, 5L
        ));

        return ImmutableList.of(
                point1,
                point2,
                point3
        );
    }
}
