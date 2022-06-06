package com.jpmc.movietheater.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jpmc.movietheater.domain.MovieSchedules;
import com.jpmc.movietheater.domain.Showing;
import com.jpmc.movietheater.domain.Theater;
import com.jpmc.movietheater.provider.LocalDateProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
public class TheatreController {
    //@Autowired
    Theater theater = new Theater(LocalDateProvider.singleton());

    @GetMapping("/schedule")
    public String printSchedule(){
        return theater.printSchedule().replace("\n", "<br />\n");
    }

    @GetMapping("/scheduleJson")
    public String printScheduleJson()
    {
        return theater.printScheduleJson();
    }

    public void setTheater(Theater theater) {
        this.theater = theater;
    }
}
