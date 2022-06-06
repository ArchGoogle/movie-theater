package com.jpmc.movietheater.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MovieSchedules {
    String currentDate;
    List<MovieSchedule> movieScheduleList;

    public MovieSchedules(String currentDate, List<Showing> showings) {
        this.currentDate = currentDate;
        movieScheduleList = new ArrayList<>();
        for(Showing showing:showings){
            movieScheduleList.add(new MovieSchedule(showing));
        }
    }

    public String getCurrentDate() {
        return currentDate;
    }

    public void setCurrentDate(String currentDate) {
        this.currentDate = currentDate;
    }

    public List<MovieSchedule> getMovieScheduleList() {
        return movieScheduleList;
    }

    public void setMovieScheduleList(List<MovieSchedule> movieScheduleList) {
        this.movieScheduleList = movieScheduleList;
    }
}
