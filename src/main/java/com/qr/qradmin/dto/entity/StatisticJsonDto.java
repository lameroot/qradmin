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
//    private Multimap<String, Object> dataList = MultimapBuilder.SortedSetMultimapBuilder.treeKeys().linkedListValues().build();
    private Map<String, Map<String,Object>> dataList = new HashMap<>();


    private Set<String> fields = new HashSet<>();
    private List<Map<String,Object>> data = new ArrayList<>();


    public Set<String> getFields() {
        return fields;
    }

    public List getData() {
        return data;
    }

    public StatisticJsonDto addDataForOrderTemplate(String slotName, String orderTemplateName, Long value) {
//        dataList.put(slotName, slotName);
//        dataList.put(orderTemplateName, value);

        fields.add("name");
        fields.add(orderTemplateName);

        Map<String, Object> map = new HashMap<>();
        map.put("name", slotName);
        map.put(orderTemplateName, value);



        Map map0 = dataList.get(slotName);
        if ( null == map0 ) map0 = new HashMap<>();
        map0.putAll(map);
        dataList.put(slotName, map0);

        //data.add(map);
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
            //System.out.println(slot);
            statisticJsonDto.addDataForOrderTemplate(slot.getName(),"t1", 10L);
            statisticJsonDto.addDataForOrderTemplate(slot.getName(),"t2", 20L);
            statisticJsonDto.addDataForOrderTemplate(slot.getName(),"t3", 30L);

//            statisticJsonDto.dataList.put(slot.getName(),12);
//            statisticJsonDto.dataList.put(slot.getName(),13);
//            statisticJsonDto.dataList.put(slot.getName(),14);
//            statisticJsonDto.dataList.put(slot.getName(),15);
//            statisticJsonDto.dataList.put(slot.getName(),16);
//            statisticJsonDto.dataList.put(slot.getName(),17);
//            statisticJsonDto.dataList.put(slot.getName(),18);

        }

//        statisticJsonDto.fields = statisticJsonDto.dataList.keySet();
//        for (Map.Entry<String, Collection<Object>> entry : statisticJsonDto.dataList.asMap().entrySet()) {
//            Map<String, Object> map = new LinkedHashMap<>();
//            map.put("name",entry.getKey());
//            map.put("t1",entry.getValue().toArray()[0]);
//            map.put("t2",entry.getValue().toArray()[1]);
//            statisticJsonDto.data.add(map);
//        }


        statisticJsonDto.buildData();
        ObjectMapper objectMapper = new ObjectMapper();
        String s = objectMapper.writeValueAsString(statisticJsonDto);
        System.out.println(s);




    }
}
