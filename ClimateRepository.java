package com.example.weather.repository;

import com.example.weather.model.Climate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;

public interface ClimateRepository extends JpaRepository<Climate, Long> {

    // 1️⃣ Exact date-time match
    List<Climate> findByDatetimeUtc(LocalDateTime datetimeUtc);

    // 2️⃣ Get all data for a specific month (across 20 years)
    @Query("""
        SELECT c FROM Climate c
        WHERE EXTRACT(MONTH FROM c.datetimeUtc) = :month
    """)
    List<Climate> findByMonth(int month);

    // 3️⃣ Get all temperatures for a specific year (used to calculate stats)
    @Query("""
        SELECT c FROM Climate c
        WHERE EXTRACT(YEAR FROM c.datetimeUtc) = :year
    """)
    List<Climate> findByYear(int year);
}
