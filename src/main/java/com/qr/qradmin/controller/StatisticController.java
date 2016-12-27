package com.qr.qradmin.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qr.qradmin.generic.ElementResponse;
import com.qr.qradmin.generic.Response;
import com.qr.qradmin.service.dto.StatisticDtoService;
import com.qr.qradmin.validator.entity.StatisticDtoValidator;
import com.qr.qradmin.validator.filter.StatisticFilterDtoValidator;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.*;

@Controller
@RequestMapping("/api/statistics")
public class StatisticController  {

    @Resource
    private StatisticDtoService statisticDtoService;
    @Resource
    private StatisticDtoValidator statisticDtoValidator;
    @Resource
    private StatisticFilterDtoValidator statisticFilterDtoValidator;

    @RequestMapping
    @ResponseBody
    public ElementResponse get() {
        List<Map<String,Object>> data = new ArrayList<>();
        Map<String,Object> map1 = new LinkedHashMap<>();
        map1.put("month","Jn");
        map1.put("data1",1);
        map1.put("data2",2);
        map1.put("data3",3);

        Map<String,Object> map2 = new LinkedHashMap<>();
        map2.put("month","Dec");
        map2.put("data1",7);
        map2.put("data2",6);
        map2.put("data3",5);

        Map<String,Object> map3 = new LinkedHashMap<>();
        map3.put("month","Feb");
        map3.put("data1",9);
        map3.put("data2",1);
        map3.put("data3",3);

        data.add(map1);
        data.add(map2);
        data.add(map3);

        return new ElementResponse<>(data);
    }
}
