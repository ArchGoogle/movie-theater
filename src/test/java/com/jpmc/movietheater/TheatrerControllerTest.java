package com.jpmc.movietheater;


import com.jpmc.movietheater.controller.TheatreController;
import com.jpmc.movietheater.domain.Theater;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;
@RunWith(MockitoJUnitRunner.class)
public class TheatrerControllerTest {

    TheatreController controller;
    @Mock
    Theater theater;
    @Before
    public void init(){
        controller = new TheatreController();
        controller.setTheater(theater);
    }
    @Test
    public void testSchedule(){
        Mockito.when(theater.printSchedule()).thenReturn("testSchedule");
        String schedule = controller.printSchedule();
        Mockito.verify(theater).printSchedule();
        assertEquals("testSchedule",schedule);
    }
    @Test
    public void testScheduleJson(){
        Mockito.when(theater.printScheduleJson()).thenReturn("testScheduleJson");
        String schedule = controller.printScheduleJson();
        Mockito.verify(theater).printScheduleJson();
        assertEquals("testScheduleJson",schedule);
    }
}
