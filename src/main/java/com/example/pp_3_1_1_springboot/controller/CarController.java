package com.example.pp_3_1_1_springboot.controller;

import com.example.pp_3_1_1_springboot.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/cars")
public class CarController {

    private final CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping
    public String showCars(@RequestParam(value = "count", defaultValue = "5") int count,
                           Model model) {
        model.addAttribute("cars", carService.getCars(count));
        return "cars";
    }
}


