package com.jpmc.movietheater.rule.impl;

import com.jpmc.movietheater.domain.Movie;
import com.jpmc.movietheater.domain.Showing;
import com.jpmc.movietheater.rule.DiscountRule;


public class ShowingSequenceRule implements DiscountRule {
    private int showSeq;
    private boolean isPercentageDiscount;
    private double discount;

    public ShowingSequenceRule(int showSeq, boolean isPercentageDiscount, double discount) {
        this.showSeq = showSeq;
        this.isPercentageDiscount = isPercentageDiscount;
        this.discount = discount;
    }

    @Override
    public double getDiscount(Movie movie, Showing showing) {
        if(showing.getSequenceOfTheDay()==showSeq)
        {
            if(isPercentageDiscount) return movie.getTicketPrice()*discount/100;
            else return discount;
        }
        return 0;
    }
}
