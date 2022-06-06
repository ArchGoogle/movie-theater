package com.jpmc.movietheater.domain;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class MovieSchedule {
    int sequenceOfDay;
    String startTime;
    String title;
    String runningTime;
    String movieFee;

    public MovieSchedule(Showing showing) {
        this.sequenceOfDay = showing.getSequenceOfTheDay();
        this.title = showing.getMovie().getTitle();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
        this.startTime = formatter.format(showing.getStartTime());
        this.runningTime = String.format("%dhour %02dminutes",
                showing.getMovie().getRunningTime().toHours(),
                showing.getMovie().getRunningTime().toMinutesPart());
        this.movieFee = "$"+showing.getMovieFee();
    }

    public int getSequenceOfDay() {
        return sequenceOfDay;
    }

    public void setSequenceOfDay(int sequenceOfDay) {
        this.sequenceOfDay = sequenceOfDay;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getRunningTime() {
        return runningTime;
    }

    public void setRunningTime(String runningTime) {
        this.runningTime = runningTime;
    }

    public String getMovieFee() {
        return movieFee;
    }

    public void setMovieFee(String movieFee) {
        this.movieFee = movieFee;
    }
}
