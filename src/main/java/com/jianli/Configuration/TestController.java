package com.jianli.Configuration;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/test")
public class TestController {

    @RequestMapping(method = RequestMethod.GET)
    public String get() {
        return "GET Received";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String post() {
        return "POST Received";
    }
}
