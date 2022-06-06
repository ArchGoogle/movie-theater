package com.jpmc.movietheater.rule.impl;

import com.jpmc.movietheater.domain.Movie;
import com.jpmc.movietheater.domain.Showing;
import com.jpmc.movietheater.rule.DiscountRule;


import java.time.LocalDateTime;

public class ShowingDateRule implements DiscountRule {

    private LocalDateTime showingDate;
    private boolean isPercentage;
    private double discount;

    public ShowingDateRule( LocalDateTime showingDate, boolean isPercentage, double discount) {
        this.showingDate = showingDate;
        this.isPercentage = isPercentage;
        this.discount = discount;
    }

    @Override
    public double getDiscount(Movie movie, Showing showing) {
        if(showing.getStartTime().isEqual(showingDate))
            return isPercentage?movie.getTicketPrice()*discount/100:discount;
        return 0;
    }
}
