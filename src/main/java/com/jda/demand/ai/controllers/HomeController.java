package com.jda.demand.ai.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/")
public class HomeController {

    @ResponseBody
    @RequestMapping(method= RequestMethod.GET)
    public String home() {
        return "Hello World";
    }
}
