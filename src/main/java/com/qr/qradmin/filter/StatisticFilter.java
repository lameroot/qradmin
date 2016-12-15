package com.qr.qradmin.filter;

import com.qr.qradmin.generic.EntityFilter;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.function.Function;

public class StatisticFilter extends EntityFilter {

    private TimeSlot timeSlot;
    private Date before;
    private List<Long> orderTemplateIds;


    public static enum TimeSlot {
        HOUR(12,5),
        DAY(24,60),
        WEEK(7,1440),
        MONTH(30,10080),
        YEAR(365,43800);

        private final int countSlots;
        private final int countMinutes;
        private Function function;

        TimeSlot(int countSlots, int countMinutes) {
            this.countSlots = countSlots;
            this.countMinutes = countMinutes;

        }

        public List<Slot> getSlots(Calendar before) {
            int tmp = countSlots;
            List<Slot> slots = new ArrayList<>();
            while (tmp-- > 0) {
                Slot slot = new Slot();
                slot.endTime = before.getTime();
                before.add(Calendar.MINUTE,-countMinutes);
                slot.startTime = before.getTime();
                slots.add(slot);

            }
            return slots;
        }
    }

    public static class Slot {
        Date startTime;
        Date endTime;
    }
}
