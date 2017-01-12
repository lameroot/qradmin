package com.qr.qradmin.dto.entity;

import java.util.Map;

/**
 * x - название промежутка времени (скорее всего в таком же виде будет отображаться на графике)
 * y - набор точек в одной колонке,
 * ключ - id группы (например, терминала или шаблона)
 * значение - значение, которое нужно отобразить
 */
public class StatisticPointDto {
    private String x;
    private Map<Long, Long> y;

    public String getX() {
        return x;
    }

    public void setX(String x) {
        this.x = x;
    }

    public Map<Long, Long> getY() {
        return y;
    }

    public void setY(Map<Long, Long> y) {
        this.y = y;
    }
}
