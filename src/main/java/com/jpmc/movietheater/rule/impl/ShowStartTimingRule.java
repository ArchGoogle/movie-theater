package com.jpmc.movietheater.rule.impl;

import com.jpmc.movietheater.domain.Movie;
import com.jpmc.movietheater.domain.Showing;
import com.jpmc.movietheater.rule.DiscountRule;


import java.time.LocalDateTime;

public class ShowStartTimingRule implements DiscountRule {
    private LocalDateTime startTimeBegin;
    private LocalDateTime startTimeEnd;
    private boolean isPercentageDiscount;
    private double discount;

    public ShowStartTimingRule(LocalDateTime startTimeBegin, LocalDateTime startTimeEnd, boolean isPercentageDiscount, double discount) {
        this.startTimeBegin = startTimeBegin;
        this.startTimeEnd = startTimeEnd;
        this.isPercentageDiscount = isPercentageDiscount;
        this.discount = discount;
    }

    @Override
    public double getDiscount(Movie movie, Showing showing) {
        if(showing.getStartTime().isAfter(startTimeBegin) && showing.getStartTime().isBefore(startTimeEnd)){
            if(isPercentageDiscount)
                return movie.getTicketPrice()*discount/100;
            else
                return discount;
        }
        return 0;
    }
}
