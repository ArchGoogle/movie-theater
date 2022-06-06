package com.jpmc.movietheater.rule;

import com.jpmc.movietheater.domain.Movie;
import com.jpmc.movietheater.domain.Showing;


public interface DiscountRule {

    public double getDiscount(Movie movie, Showing showing);
}
