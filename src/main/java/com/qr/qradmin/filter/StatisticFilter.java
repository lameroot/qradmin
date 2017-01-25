package com.qr.qradmin.filter;

import com.qr.qradmin.enums.statistics.CalculationType;
import com.qr.qradmin.enums.statistics.Grouping;
import com.qr.qradmin.enums.statistics.IndicatorType;
import com.qr.qradmin.enums.statistics.TimeSlot;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class StatisticFilter {

    private Grouping grouping;
    private IndicatorType indicatorType;
    private CalculationType calculationType;
    private Date dateFrom;
    private Date dateTo;
    private Long[] selectedOrderTemplatesIds;
    private Long[] selectedTerminalsIds;
    private boolean separatelyForTerminals;
    private boolean separatelyForOrderTemplates;

    public Grouping getGrouping() {
        return grouping;
    }

    public void setGrouping(Grouping grouping) {
        this.grouping = grouping;
    }

    public IndicatorType getIndicatorType() {
        return indicatorType;
    }

    public void setIndicatorType(IndicatorType indicatorType) {
        this.indicatorType = indicatorType;
    }

    public CalculationType getCalculationType() {
        return calculationType;
    }

    public void setCalculationType(CalculationType calculationType) {
        this.calculationType = calculationType;
    }

    public Date getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(Date dateFrom) {
        this.dateFrom = dateFrom;
    }

    public Date getDateTo() {
        return dateTo;
    }

    public void setDateTo(Date dateTo) {
        this.dateTo = dateTo;
    }

    public Long[] getSelectedOrderTemplatesIds() {
        return selectedOrderTemplatesIds;
    }

    public void setSelectedOrderTemplatesIds(Long[] selectedOrderTemplatesIds) {
        this.selectedOrderTemplatesIds = selectedOrderTemplatesIds;
    }

    public Long[] getSelectedTerminalsIds() {
        return selectedTerminalsIds;
    }

    public void setSelectedTerminalsIds(Long[] selectedTerminalsIds) {
        this.selectedTerminalsIds = selectedTerminalsIds;
    }

    public boolean isSeparatelyForTerminals() {
        return separatelyForTerminals;
    }

    public void setSeparatelyForTerminals(boolean separatelyForTerminals) {
        this.separatelyForTerminals = separatelyForTerminals;
    }

    public boolean isSeparatelyForOrderTemplates() {
        return separatelyForOrderTemplates;
    }

    public void setSeparatelyForOrderTemplates(boolean separatelyForOrderTemplates) {
        this.separatelyForOrderTemplates = separatelyForOrderTemplates;
    }

    public List<com.qr.qradmin.enums.statistics.TimeSlot> getTimeSlots() {
        Calendar start = Calendar.getInstance();
        start.setTime(dateFrom);
        long diff = dateTo.getTime() - dateFrom.getTime();

        List<com.qr.qradmin.enums.statistics.TimeSlot> timeSlots = new ArrayList<>();
        do {
            com.qr.qradmin.enums.statistics.TimeSlot timeSlot = new com.qr.qradmin.enums.statistics.TimeSlot();
            timeSlot.setStartTime(start.getTime());
            String name = "";
            switch (grouping) {
                case DAY: {
                    name = start.get(Calendar.DAY_OF_MONTH) + " " + new SimpleDateFormat("MMM").format(start.getTime());
                    start.add(Calendar.DAY_OF_YEAR,1);
                    break;
                }
                case WEEK: {
                    name = start.get(Calendar.DAY_OF_MONTH) + " " + new SimpleDateFormat("MMM").format(start.getTime());
                    start.add(Calendar.WEEK_OF_YEAR,1);
                    name += " - " + start.get(Calendar.DAY_OF_MONTH) + " " + new SimpleDateFormat("MMM").format(start.getTime());
                    break;
                }
                case MONTH: {
                    name = new SimpleDateFormat("MMM").format(start.getTime()) + " - ";
                    start.add(Calendar.MONTH,1);
                    name += new SimpleDateFormat("MMM").format(start.getTime());
                    break;
                }
            }
            timeSlot.setName(name);
            timeSlot.setEndTime(start.getTime());
            timeSlots.add(timeSlot);
        } while (start.getTime().before(dateTo));

        return timeSlots;
    }



    public static void main(String[] args) {
        StatisticFilter statisticFilter = new StatisticFilter();
        statisticFilter.setGrouping(Grouping.WEEK);
        Calendar dateFrom = Calendar.getInstance();
        dateFrom.add(Calendar.MONTH,-2);
        Calendar dateTo = Calendar.getInstance();

        statisticFilter.setDateFrom(dateFrom.getTime());
        statisticFilter.setDateTo(dateTo.getTime());

        List<TimeSlot> timeSlots = statisticFilter.getTimeSlots();
        for (TimeSlot timeSlot : timeSlots) {
            System.out.println(timeSlot.getName() + " = " + timeSlot.getStartTime() + " - " + timeSlot.getEndTime());
        }


    }
}
