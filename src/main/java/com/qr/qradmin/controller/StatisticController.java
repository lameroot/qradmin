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
    public Response get() {
        List<Map<String,String>> data = new ArrayList<>();
        Map<String,String> map1 = new LinkedHashMap<>();
        map1.put("name","Jn");
        map1.put("1","10");
        map1.put("2","20");
        map1.put("3","30");

        Map<String,String> map2 = new LinkedHashMap<>();
        map2.put("name","Dec");
        map2.put("1","10");
        map2.put("2","20");
        map2.put("3","30");

        Map<String,String> map3 = new LinkedHashMap<>();
        map3.put("name","Feb");
        map3.put("1","10");
        map3.put("2","20");
        map3.put("3","30");

        data.add(map1);
        data.add(map2);
        data.add(map3);

        ObjectMapper objectMapper = new ObjectMapper();



        ElementResponse elementResponse = new ElementResponse(data);
        return elementResponse;
    }
}
