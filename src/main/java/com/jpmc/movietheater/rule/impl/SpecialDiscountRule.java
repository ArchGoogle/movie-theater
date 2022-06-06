package com.jpmc.movietheater.rule.impl;

import com.jpmc.movietheater.domain.Movie;
import com.jpmc.movietheater.domain.Showing;
import com.jpmc.movietheater.rule.DiscountRule;


public class SpecialDiscountRule implements DiscountRule {
    @Override
    public double getDiscount(Movie movie, Showing showing) {
        if(movie.getSpecialCode() == 1)
            return movie.getTicketPrice()*0.2;
        else
            return 0;
    }
}
