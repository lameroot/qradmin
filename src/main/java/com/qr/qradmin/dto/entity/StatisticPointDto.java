package com.qr.qradmin.dto.entity;

import java.util.HashMap;
import java.util.Map;

/**
 * x - название промежутка времени (скорее всего в таком же виде будет отображаться на графике)
 * y - набор точек в одной колонке,
 * ключ - id группы (например, терминала или шаблона)
 * значение - значение, которое нужно отобразить
 */
public class StatisticPointDto {
    private String x;
    private Map<String, Long> y = new HashMap<>();

    public String getX() {
        return x;
    }

    public void setX(String x) {
        this.x = x;
    }

    public Map<String, Long> getY() {
        return y;
    }

    public void setY(Map<String, Long> y) {
        this.y = y;
    }
}
