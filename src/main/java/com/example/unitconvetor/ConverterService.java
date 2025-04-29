package com.example.unitconvetor;

import org.springframework.stereotype.Service;

@Service
public class ConverterService {
    public double convert(String type, double value, String from, String to) {
        switch (type){
            case "length":
                if (from.equals("meter") && to.equals("kilometer")) return value / 1000;
                if (from.equals("kilometer") && to.equals("meter")) return value * 1000;
                break;
            case "weight":
                if (from.equals("gram") && to.equals("kilogram")) return value / 1000;
                if (from.equals("kilogram") && to.equals("gram")) return value * 1000;
                break;
            case "temperature":
                if (from.equals("celsius") && to.equals("fahrenheit")) return (value * 9/5) + 32;
                if (from.equals("fahrenheit") && to.equals("celsius")) return (value - 32) * 5/9;
                break;
        }
        return  value;
    }
}
