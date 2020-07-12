package com.shoban.controllers;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.shoban.filter.TestBean;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FilterController {

    @GetMapping("/filterfields")
    public MappingJacksonValue filterFields(){
        TestBean tstBean = new TestBean("V1", "V2", "V3");
        SimpleBeanPropertyFilter sbFilter = SimpleBeanPropertyFilter.filterOutAllExcept("value1", "value2");
        FilterProvider filterProvider = new SimpleFilterProvider().addFilter("TestBeanFilter", sbFilter);
        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(tstBean);
        mappingJacksonValue.setFilters(filterProvider);

        return mappingJacksonValue;
    }
}
