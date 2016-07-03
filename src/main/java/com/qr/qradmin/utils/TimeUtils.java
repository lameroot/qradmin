package com.qr.qradmin.utils;

import java.util.Calendar;
import java.util.Date;

public class TimeUtils {
    public static Date convert_InMinutes_to_AtTime(Long inMinutes) {
        if (inMinutes == null) return new Date();
        Calendar c = Calendar.getInstance();
        c.add(Calendar.MINUTE, inMinutes.intValue());
        return c.getTime();
    }

    public static Long convert_AtTime_to_InMinutes(Date atTime) {
        return (atTime.getTime() - new Date().getTime()) / 60000;
    }
}
