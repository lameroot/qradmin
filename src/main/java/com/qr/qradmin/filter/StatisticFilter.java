package com.qr.qradmin.filter;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class StatisticFilter {

    private TimeSlot timeSlot;
    private Calendar before;
    private List<Long> orderTemplateIds;
    private Long merchantId;

    public TimeSlot getTimeSlot() {
        return timeSlot;
    }

    public void setTimeSlot(TimeSlot timeSlot) {
        this.timeSlot = timeSlot;
    }

    public Calendar getBefore() {
        return before;
    }

    public void setBefore(Calendar before) {
        this.before = before;
    }

    public List<Long> getOrderTemplateIds() {
        return orderTemplateIds;
    }

    public void setOrderTemplateIds(List<Long> orderTemplateIds) {
        this.orderTemplateIds = orderTemplateIds;
    }

    public Long getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(Long merchantId) {
        this.merchantId = merchantId;
    }

    public static enum TimeSlot {
        HOUR(12,5, new SimpleDateFormat("mm")),
        DAY(24,60, new SimpleDateFormat("HH")),
        WEEK(7,1440, new SimpleDateFormat("EE")),
        MONTH(30,1440, new SimpleDateFormat("dd")),
        YEAR(12,43800, new SimpleDateFormat("MMM"));

        private final int countSlots;
        private final int countMinutes;
        private final SimpleDateFormat dateFormat;

        TimeSlot(int countSlots, int countMinutes, SimpleDateFormat dateFormat) {
            this.countSlots = countSlots;
            this.countMinutes = countMinutes;
            this.dateFormat = dateFormat;

        }

        public List<Slot> getSlots(Calendar b) {
            Calendar before = Calendar.getInstance();
            before.setTime(b.getTime());
            int tmp = countSlots;
            List<Slot> slots = new ArrayList<>();
            while (tmp-- > 0) {
                Slot slot = new Slot();
                slot.endTime = before.getTime();
                before.add(Calendar.MINUTE,-countMinutes);
                slot.startTime = before.getTime();
                slot.name = dateFormat.format(slot.startTime);
                slots.add(slot);

            }
            return slots;
        }


    }

    public static class Slot {
        Date startTime;
        Date endTime;
        String name;

        public Date getStartTime() {
            return startTime;
        }

        public Date getEndTime() {
            return endTime;
        }

        public String getName() {
            return name;
        }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("Slot{");
            sb.append("startTime=").append(startTime);
            sb.append(", endTime=").append(endTime);
            sb.append(", name='").append(name).append('\'');
            sb.append('}');
            return sb.toString();
        }
    }

    public static void main(String[] args) {
        Calendar now = Calendar.getInstance();
        List<Slot> slots = TimeSlot.DAY.getSlots(now);
        for (Slot slot : slots) {
            System.out.println(slot);
        }


    }
}
