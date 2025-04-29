package com.example.unitconvetor;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ConvertorController {
    private final ConverterService converterService;

    public ConvertorController(ConverterService convertService){
        this.converterService = convertService;

    }
    @GetMapping("/")
    public String showForm(){
        return "index";
    }
    @PostMapping("/convert")
    public String convert(@RequestParam double value, @RequestParam String type, @RequestParam String fromUnit, @RequestParam String toUnit, Model model){
        double result=converterService.convert(type,value,fromUnit,toUnit);
        model.addAttribute("value",value);
        model.addAttribute("fromUnit",fromUnit);
        model.addAttribute("toUnit",toUnit);
        model.addAttribute("result",result);
        return  "result";

    }
}
