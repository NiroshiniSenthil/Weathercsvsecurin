package com.example.weather.controller;

import com.example.weather.model.Climate;
import com.example.weather.service.ClimateService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/weather")
public class ClimateController {

    @Autowired
    private ClimateService climateService;

    
    @GetMapping("/load-csv")
public String loadCsv() {
    climateService.loadCsvData();
    return "CSV Loaded Successfully";
}
    @GetMapping("/by-date")
    public List<Climate> getWeatherByDate(
            @RequestParam("date")
            @DateTimeFormat(pattern = "yyyyMMdd-HH:mm") String date) {

        return climateService.getWeatherByDate(date);
    }
   
    @GetMapping("/by-month")
    public List<Climate> getWeatherByMonth(@RequestParam("month") int month) {
        return climateService.getWeatherByMonth(month);
    }
    
    @GetMapping("/temperature-stats")
    public List<Map<String, Object>> getMonthlyTemperatureStats(@RequestParam("year") int year) {
        return climateService.getMonthlyTemperatureStats(year);
    }

}
