package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class calculatorController {
    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/calculate")
    public String calculate(@RequestParam(name = "firstVal", required = false, defaultValue = "0") double firstval,
                            @RequestParam(name = "secval", required = false, defaultValue = "0") double secval,
                            @RequestParam(name = "select", required = false, defaultValue = "+") String mathval, Model model) {
        return getString(firstval, secval, mathval, model);
    }

    @PostMapping("/calculate")
    public String POSTcalculate(@RequestParam(name = "firstVal", required = false, defaultValue = "0") double firstval,
                                @RequestParam(name = "secval", required = false, defaultValue = "0") double secval,
                                @RequestParam(name = "select", required = false, defaultValue = "+") String select, Model model) {
        return getString(firstval, secval, select, model);
    }

    private String getString(@RequestParam(name = "First", required = false, defaultValue = "0") double First,
                             @RequestParam(name = "Second", required = false, defaultValue = "0") double Second,
                             @RequestParam(name = "select", required = false, defaultValue = "+") String select, Model model) {
        double res = switch (select) {
            case "plus" -> First + Second;
            case "minus" -> First - Second;
            case "multiply" -> First * Second;
            case "divide" -> First / Second;
            default -> 0;
        };
        model.addAttribute("res", res);

        return "Answer";
    }
}