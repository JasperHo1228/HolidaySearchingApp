package com.example.demo.Service;

import com.example.demo.Entity.Vevent;
import com.example.demo.Repository.HolidayRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class HolidayService {

    private final HolidayRepository holidayRepository;

    public HolidayService(HolidayRepository holidayRepository) {
        this.holidayRepository = holidayRepository;
    }

    public List<Vevent> list(){
        return holidayRepository.findAll();
    }

    public List<Vevent> save(List<Vevent> holidayList){
        return holidayRepository.saveAll(holidayList);
    }
    public List<Vevent> findByDtstart(LocalDate dtstart ,LocalDate dtend){
        return holidayRepository.findByStartDateAfter(dtstart,dtend);}
    public List<Vevent> findByDtend(LocalDate dtstart,LocalDate dtend){
        return holidayRepository.findByStartDateBefore(dtstart, dtend);}

}
