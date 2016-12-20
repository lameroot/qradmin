package com.qr.qradmin.service.entity;

import com.qr.qradmin.dao.StatisticAdminRepository;
import org.springframework.stereotype.Service;
import ru.qrhandshake.qrpos.domain.Statistic;

import javax.annotation.Resource;
import java.util.Date;

@Service
public class StatisticAdminService  {

    @Resource
    private StatisticAdminRepository statisticAdminRepository;

    public Long sumByPeriod(Statistic.StatisticType type, Date startTime, Date endTime, Long merchantId, Long... orderTemplateIds ) {
        return null == orderTemplateIds || 0 == orderTemplateIds.length
                ? statisticAdminRepository.sumByPeriod(type, merchantId, endTime.getTime(), startTime.getTime())
                : statisticAdminRepository.sumByPeriod(type, merchantId, orderTemplateIds, endTime.getTime(), startTime.getTime());
    }
}
