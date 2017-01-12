package com.qr.qradmin.dto.filter;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.qr.qradmin.enums.statistics.CalculationType;
import com.qr.qradmin.enums.statistics.Grouping;
import com.qr.qradmin.enums.statistics.IndicatorType;

import java.util.Date;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class StatisticFilterDto {
    private Date dateFrom;
    private Date dateTo;

    private Grouping grouping;
    private IndicatorType indicatorType;
    private CalculationType calculationType;

    private boolean separatelyForTerminals;
    private List<Long> selectedTerminalsIds;

    private boolean separatelyForOrderTemplates;
    private List<Long> selectedOrderTemplatesIds;

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

    public boolean isSeparatelyForTerminals() {
        return separatelyForTerminals;
    }

    public void setSeparatelyForTerminals(boolean separatelyForTerminals) {
        this.separatelyForTerminals = separatelyForTerminals;
    }

    public List<Long> getSelectedTerminalsIds() {
        return selectedTerminalsIds;
    }

    public void setSelectedTerminalsIds(List<Long> selectedTerminalsIds) {
        this.selectedTerminalsIds = selectedTerminalsIds;
    }

    public boolean isSeparatelyForOrderTemplates() {
        return separatelyForOrderTemplates;
    }

    public void setSeparatelyForOrderTemplates(boolean separatelyForOrderTemplates) {
        this.separatelyForOrderTemplates = separatelyForOrderTemplates;
    }

    public List<Long> getSelectedOrderTemplatesIds() {
        return selectedOrderTemplatesIds;
    }

    public void setSelectedOrderTemplatesIds(List<Long> selectedOrderTemplatesIds) {
        this.selectedOrderTemplatesIds = selectedOrderTemplatesIds;
    }
}
