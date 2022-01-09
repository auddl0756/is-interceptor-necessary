package org.roon.carrier.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/sample")
@Controller
public class SampleController {

    @ResponseBody
    @GetMapping
    public String hello() {
        return "hello";
    }

}
