package com.example.demo.Controller;

import com.example.demo.Service.HolidayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Controller
public class HolidayController {

    @Autowired
    private HolidayService holidayService;

    public HolidayController(HolidayService holidayService) {
        this.holidayService = holidayService;
    }

    @GetMapping("/home")
    public String home(){
        return "Home";
    }

    @GetMapping("/home/filter")
    public String filterData(Model model, String dtstart,  String dtend) {
        if ((dtstart != null && !dtstart.isEmpty()) && (dtend != null && !dtend.isEmpty())) {
            LocalDate start = LocalDate.parse(dtstart, DateTimeFormatter.ISO_DATE);
            LocalDate end = LocalDate.parse(dtend, DateTimeFormatter.ISO_DATE);
            model.addAttribute("data",holidayService.findByDtstart(start,end));
            model.addAttribute("data",holidayService.findByDtend(start,end));
        }
        return "Home";
    }

    @GetMapping("/home/all")
    public String getData(Model model) {
        model.addAttribute("data", holidayService.list());
        return "Home";
    }
}


