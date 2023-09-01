package com.bobr.realtyhelper.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    @RequestMapping("/secured")
    public String test() {
        return "Nice, you have access to secured area";
    }
}
