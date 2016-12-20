package com.qr.qradmin.dto.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.qr.qradmin.filter.StatisticFilter;

import java.util.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class StatisticJsonDto {

    @JsonIgnore
    private Map<String, Map<String,Object>> dataList = new LinkedHashMap<>();


    private Set<String> fields = new HashSet(){{
        add("name");
    }};
    private List<Map<String,Object>> data = new ArrayList<>();


    public Set<String> getFields() {
        return fields;
    }

    public List getData() {
        return data;
    }

    public StatisticJsonDto addDataForOrderTemplate(String slotName, String orderTemplateName, Long value) {
        fields.add(orderTemplateName);

        Map<String, Object> map = new HashMap<>();
        map.put("name", slotName);
        map.put(orderTemplateName, value);


        Map map0 = dataList.get(slotName);
        if ( null == map0 ) map0 = new HashMap<>();
        map0.putAll(map);
        dataList.put(slotName, map0);

        return this;
    }

    public StatisticJsonDto buildData() {
        for (Map.Entry<String, Map<String, Object>> entry : dataList.entrySet()) {
            Map m = (Map)entry.getValue();
            data.add(m);
        }
        return this;
    }

    public static void main(String[] args) throws JsonProcessingException {
        StatisticJsonDto statisticJsonDto = new StatisticJsonDto();

        Calendar now = Calendar.getInstance();
        List<StatisticFilter.Slot> slots = StatisticFilter.TimeSlot.WEEK.getSlots(now);
        for (StatisticFilter.Slot slot : slots) {
            System.out.println(slot);
            statisticJsonDto.addDataForOrderTemplate(slot.getName(),"t1", 10L);
            statisticJsonDto.addDataForOrderTemplate(slot.getName(),"t2", 20L);
            statisticJsonDto.addDataForOrderTemplate(slot.getName(),"t3", 30L);

        }

        statisticJsonDto.buildData();
        ObjectMapper objectMapper = new ObjectMapper();
        String s = objectMapper.writeValueAsString(statisticJsonDto);
        System.out.println(s);




    }
}
