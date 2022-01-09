package org.roon.carrier.web.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;

@Log4j2
@RequestMapping("/sample")
@Controller
public class SampleController {

    @ResponseBody
    @GetMapping
    public String hello(HttpServletResponse response) {
        return "hello";
    }

}
