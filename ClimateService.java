package com.example.weather.service;

import com.example.weather.model.Climate;
import com.example.weather.repository.ClimateRepository;
import com.opencsv.CSVReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Service
public class ClimateService {

    @Autowired
    private ClimateRepository climateRepository;


public void loadCsvData() {

    try {
        ClassPathResource resource =
                new ClassPathResource("weather.csv");

        CSVReader reader = new CSVReader(
                new InputStreamReader(resource.getInputStream()));

        List<String[]> rows = reader.readAll();

        DateTimeFormatter formatter =
                DateTimeFormatter.ofPattern("yyyyMMdd-HH:mm");

        for (int i = 1; i < rows.size(); i++) { 
            String[] row = rows.get(i);

            Climate climate = new Climate();

            LocalDateTime dateTime =
                    LocalDateTime.parse(row[0], formatter);

            climate.setDatetimeUtc(dateTime);
            climate.setTempm(Integer.parseInt(row[1]));

            climateRepository.save(climate);
        }

        System.out.println("CSV Data Loaded Successfully");

    } catch (Exception e) {
        e.printStackTrace();
    }
}

    public List<Climate> getWeatherByDate(String date) {

        DateTimeFormatter formatter =
                DateTimeFormatter.ofPattern("yyyyMMdd-HH:mm");

        LocalDateTime dateTime =
                LocalDateTime.parse(date, formatter);

        return climateRepository.findByDatetimeUtc(dateTime);
    }

    
    public List<Climate> getWeatherByMonth(int month) {
        return climateRepository.findByMonth(month);
    }

    
    public List<Map<String, Object>> getMonthlyTemperatureStats(int year) {

        List<Climate> yearlyData = climateRepository.findByYear(year);

        Map<Integer, List<Integer>> monthTempMap = new HashMap<>();

        
        for (Climate climate : yearlyData) {

            int month = climate.getDatetimeUtc().getMonthValue();

            monthTempMap
                    .computeIfAbsent(month, k -> new ArrayList<>())
                    .add(climate.getTempm());
        }

        List<Map<String, Object>> response = new ArrayList<>();

        for (Map.Entry<Integer, List<Integer>> entry : monthTempMap.entrySet()) {

            int month = entry.getKey();
            List<Integer> temps = entry.getValue();

            Collections.sort(temps);

            int min = temps.get(0);
            int max = temps.get(temps.size() - 1);
            double median;

            int size = temps.size();
            if (size % 2 == 0) {
                median = (temps.get(size / 2 - 1) + temps.get(size / 2)) / 2.0;
            } else {
                median = temps.get(size / 2);
            }

            Map<String, Object> map = new HashMap<>();
            map.put("month", month);
            map.put("maxTemp", max);
            map.put("minTemp", min);
            map.put("medianTemp", median);

            response.add(map);
        }

        return response;
    }
}
