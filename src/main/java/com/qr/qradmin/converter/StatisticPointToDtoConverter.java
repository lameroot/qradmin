package com.qr.qradmin.converter;

import com.qr.qradmin.dto.entity.StatisticPointDto;
import com.qr.qradmin.dto.entity.UserInfoDto;
import com.qr.qradmin.model.StatisticPoint;
import com.qr.qradmin.model.UserInfo;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class StatisticPointToDtoConverter implements Converter<StatisticPoint, StatisticPointDto> {

    @Override
    public StatisticPointDto convert(StatisticPoint statisticPoint) {
        if (statisticPoint == null) return null;
        StatisticPointDto statisticPointDto = new StatisticPointDto();
        statisticPointDto.setX(statisticPoint.getX());
        statisticPointDto.setY(statisticPoint.getY());
        return statisticPointDto;
    }
}
