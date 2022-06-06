package com.jpmc.movietheater.domain;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jpmc.movietheater.provider.LocalDateProvider;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Theater {

    LocalDateProvider provider;
    private List<Showing> schedule;

    public Theater(LocalDateProvider provider) {
        this.provider = provider;

        Movie spiderMan = new Movie("Spider-Man: No Way Home", Duration.ofMinutes(90), 12.5, 1);
        Movie turningRed = new Movie("Turning Red", Duration.ofMinutes(85), 11, 0);
        Movie theBatMan = new Movie("The Batman", Duration.ofMinutes(95), 9, 0);
        schedule = List.of(
            new Showing(turningRed, 1, LocalDateTime.of(provider.currentDate(), LocalTime.of(9, 0))),
            new Showing(spiderMan, 2, LocalDateTime.of(provider.currentDate(), LocalTime.of(11, 0))),
            new Showing(theBatMan, 3, LocalDateTime.of(provider.currentDate(), LocalTime.of(12, 50))),
            new Showing(turningRed, 4, LocalDateTime.of(provider.currentDate(), LocalTime.of(14, 30))),
            new Showing(spiderMan, 5, LocalDateTime.of(provider.currentDate(), LocalTime.of(16, 10))),
            new Showing(theBatMan, 6, LocalDateTime.of(provider.currentDate(), LocalTime.of(17, 50))),
            new Showing(turningRed, 7, LocalDateTime.of(provider.currentDate(), LocalTime.of(19, 30))),
            new Showing(spiderMan, 8, LocalDateTime.of(provider.currentDate(), LocalTime.of(21, 10))),
            new Showing(theBatMan, 9, LocalDateTime.of(provider.currentDate(), LocalTime.of(23, 0)))
        );
    }

    public Reservation reserve(Customer customer, int sequence, int howManyTickets) {
        Showing showing;
        try {
            showing = schedule.get(sequence - 1);
        } catch (RuntimeException ex) {
            ex.printStackTrace();
            throw new IllegalStateException("not able to find any showing for given sequence " + sequence);
        }
        return new Reservation(customer, showing, howManyTickets);
    }

    public String printSchedule() {
        StringBuilder sb = new StringBuilder();
        sb.append(provider.currentDate()).append("\n");
        sb.append("===================================================").append("\n");;
        schedule.forEach(s ->
                sb.append(s.getSequenceOfTheDay()).append(": ").append(s.getStartTime()).append(" ")
                        .append(s.getMovie().getTitle()).append(" ")
                        .append(humanReadableFormat(s.getMovie().getRunningTime())).append(" $")
                        .append(s.getMovieFee()).append("\n")
        );
        sb.append("===================================================").append("\n");;
        System.out.println(sb.toString());
        return sb.toString();
    }
    public String printScheduleJson(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        MovieSchedules movieSchedules = new MovieSchedules(formatter.format(provider.currentDate()),schedule);
        ObjectMapper mapper = new ObjectMapper();
        mapper.findAndRegisterModules();
        String json="";
        try {
            json = mapper.writeValueAsString(movieSchedules);
            System.out.println("ResultingJSONstring = " + json);

            //System.out.println(json);
        } catch (JsonProcessingException e) {
            json = "error";
            e.printStackTrace();
        }
        return json;
    }
    public String humanReadableFormat(Duration duration) {
        long hour = duration.toHours();
        long remainingMin = duration.toMinutes() - TimeUnit.HOURS.toMinutes(duration.toHours());

        return String.format("(%s hour%s %s minute%s)", hour, handlePlural(hour), remainingMin, handlePlural(remainingMin));
    }

    // (s) postfix should be added to handle plural correctly
    private String handlePlural(long value) {
        if (value == 1) {
            return "";
        }
        else {
            return "s";
        }
    }

    public static void main(String[] args) {
        Theater theater = new Theater(LocalDateProvider.singleton());
        theater.printSchedule();
    }

    public LocalDateProvider getProvider() {
        return provider;
    }

    public List<Showing> getSchedule() {
        return schedule;
    }
}
