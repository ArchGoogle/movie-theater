package com.jpmc.movietheater;

import com.jpmc.movietheater.provider.LocalDateProvider;
import org.junit.Test;

public class LocalDateProviderTests {
    @Test
    public void makeSureCurrentTime() {
        System.out.println("current time is - " + LocalDateProvider.singleton().currentDate());
    }
}
