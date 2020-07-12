package com.shoban.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/internationdemo")
@RestController
public class InternationalizationController {

    @Autowired
    private MessageSource messageSource;

    @GetMapping(path = "/internationalization")
    public String helloWorldInternationalized() {
        return messageSource.getMessage("hi.message", null,
                LocaleContextHolder.getLocale());
    }
}
