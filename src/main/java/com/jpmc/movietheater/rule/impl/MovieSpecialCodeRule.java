package com.jpmc.movietheater.rule.impl;

import com.jpmc.movietheater.domain.Movie;
import com.jpmc.movietheater.domain.Showing;
import com.jpmc.movietheater.rule.DiscountRule;

import java.time.LocalDateTime;

public class MovieSpecialCodeRule implements DiscountRule {
    private boolean isPercentage;
    private double discount;

    public MovieSpecialCodeRule(boolean isPercentage, double discount) {
        this.isPercentage = isPercentage;
        this.discount = discount;
    }
    @Override
    public double getDiscount(Movie movie, Showing showing) {
        if(movie.getSpecialCode()==Movie.MOVIE_CODE_SPECIAL)
            return isPercentage?movie.getTicketPrice()*discount/100:discount;
        return 0;
    }
}
