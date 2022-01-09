package org.roon.carrier.web.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;

@Log4j2
@RequestMapping("/sample")
@Controller
public class SampleController {

    @ResponseBody
    @GetMapping
    public String hello(HttpServletResponse response) {
        return "hello";
    }

    @GetMapping("/list")
    public ModelAndView list(ModelAndView modelAndView) {
        modelAndView.setViewName("sample/list");
        modelAndView.addObject("list", Arrays.asList(1, 2, 3, 4, 5));

        return modelAndView;
    }
}
