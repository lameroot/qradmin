package com.qr.qradmin.service.entity;

import com.qr.qradmin.dao.OrderTemplateRepository;
import com.qr.qradmin.dao.StatisticAdminRepository;
import com.qr.qradmin.enums.statistics.CalculationType;
import com.qr.qradmin.enums.statistics.TimeSlot;
import com.qr.qradmin.filter.StatisticFilter;
import com.qr.qradmin.model.StatisticPoint;
import org.springframework.stereotype.Service;
import ru.qrhandshake.qrpos.domain.OrderTemplate;
import ru.qrhandshake.qrpos.domain.Statistic;
import ru.qrhandshake.qrpos.util.SecurityUtils;

import javax.annotation.Resource;
import java.util.*;

@Service
public class StatisticAdminService  {

    @Resource
    private StatisticAdminRepository statisticAdminRepository;
    @Resource
    private OrderTemplateRepository orderTemplateRepository;

    public Long sumByPeriod(Statistic.StatisticType type, Date startTime, Date endTime, Long merchantId, Long... orderTemplateIds ) {
        return Long.valueOf(new Random().nextInt(1000 - 1 + 1) + 1);
//        return null == orderTemplateIds || 0 == orderTemplateIds.length
//                ? statisticAdminRepository.sumByPeriod(type, merchantId, endTime.getTime(), startTime.getTime())
//                : statisticAdminRepository.sumByPeriod(type, merchantId, orderTemplateIds, endTime.getTime(), startTime.getTime());
    }

    public List<StatisticPoint> get(StatisticFilter filter) {
        Long merchantId = SecurityUtils.getCurrentUser().getMerchant().getId();
        Statistic.StatisticType statisticType = null;
        switch (filter.getIndicatorType()) {
            case SUCCESSFUL_PAYMENTS: {
                statisticType = Statistic.StatisticType.COUNT_PAID;
                break;
            }
            case UNSUCCESSFUL_PAYMENTS: {
                statisticType = Statistic.StatisticType.COUNT_DECLINED;
                break;
            }
            case MONEY: {
                statisticType = Statistic.StatisticType.AMOUNT_PAID;
                break;
            }
            default: {
                throw new IllegalArgumentException("Unknown indicator type: " + filter.getIndicatorType());
            }
        }
        List<StatisticPoint> statisticPoints = new ArrayList<>();

        for (TimeSlot timeSlot : filter.getTimeSlots()) {
            StatisticPoint statisticPoint = new StatisticPoint();
            statisticPoint.setX(timeSlot.getName());
            Map<String, Long> sums = new HashMap<>();
            if (filter.getCalculationType().equals(CalculationType.BY_TEMPLATES) || filter.getCalculationType().equals(CalculationType.BY_TEMPLATES_GROUP)) {
                //by templates
                if (filter.isSeparatelyForOrderTemplates()) {
                    for (Long orderTemplateId : filter.getSelectedOrderTemplatesIds()) {
                        OrderTemplate orderTemplate = orderTemplateRepository.findOne(orderTemplateId);
                        if (null == orderTemplate) continue;
                        Long sumByOrderTemplate = sumByPeriod(statisticType, timeSlot.getStartTime(), timeSlot.getEndTime(), merchantId, orderTemplateId);
                        sums.put(orderTemplate.getName() + "[" + orderTemplateId + "]", sumByOrderTemplate);
                    }
                } else {
                    Long sumByOrderTemplate = sumByPeriod(statisticType, timeSlot.getStartTime(), timeSlot.getEndTime(), merchantId, filter.getSelectedOrderTemplatesIds());
                    sums.put("Group from " + filter.getSelectedOrderTemplatesIds().length, sumByOrderTemplate);
                }
            }
            else if ( filter.getCalculationType().equals(CalculationType.BY_TERMINALS) || filter.getCalculationType().equals(CalculationType.BY_TERMINALS_GROUP) ) {
                //by terminals
            }
            statisticPoint.setY(sums);
            statisticPoints.add(statisticPoint);
        }

        return statisticPoints;

        /*

        StatisticPoint point1 = new StatisticPoint();
        point1.setX("Jan");
        point1.setY(ImmutableMap.of(
                "1-a", 7L,
                "3-b", 9L,
                "5-c", 1L
        ));

        StatisticPoint point2 = new StatisticPoint();
        point2.setX("Feb");
        point2.setY(ImmutableMap.of(
                "1-a", 4L,
                "3-b", 2L,
                "5-c", 7L
        ));

        StatisticPoint point3 = new StatisticPoint();
        point3.setX("Mar");
        point3.setY(ImmutableMap.of(
                "1-a", 8L,
                "3-b", 3L,
                "5-c", 5L
        ));

        return ImmutableList.of(
                point1,
                point2,
                point3
        );

        */
    }
}
