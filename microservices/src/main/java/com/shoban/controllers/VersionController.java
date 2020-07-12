package com.shoban.controllers;

import com.shoban.versioning.PojoVersion1;
import com.shoban.versioning.PojoVersion2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/versions")
@RestController
public class VersionController {
    @GetMapping(value = "/header", headers = "X-API-VERSION=1")
    public PojoVersion1 getHeaderwithVersion1(){
        PojoVersion1 pojoVersion1 = new PojoVersion1("Shoban", "India");
        return pojoVersion1;
    }
    @GetMapping(value = "/header", headers = "X-API-VERSION=2")
    public PojoVersion2 getHeaderwithVersion2(){
        PojoVersion2 pojoVersion2 = new PojoVersion2("Shoban", "India", "B'luru", "11");
        return pojoVersion2;
    }
    //application/vnd+company.category+json/xml/html
    @GetMapping(value = "/pojo/produces", produces = "application/vnd.company.app-v1+json")
    public PojoVersion1 producesV1() {
        return new PojoVersion1("Shoban", "India");
    }

    @GetMapping(value = "/pojo/produces", produces = "application/vnd.company.app-v2+json")
    public PojoVersion2 producesV2() {
        return new PojoVersion2("Shoban","India", "B'luru", "122");
    }
}
