package com.jpmc.movietheater;

import com.jpmc.movietheater.domain.Movie;
import com.jpmc.movietheater.domain.Showing;
import com.jpmc.movietheater.rule.DiscountRule;
import com.jpmc.movietheater.rule.impl.MovieSpecialCodeRule;
import com.jpmc.movietheater.rule.impl.ShowStartTimingRule;
import com.jpmc.movietheater.rule.impl.ShowingDateRule;
import com.jpmc.movietheater.rule.impl.ShowingSequenceRule;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class DiscountCalculator {

    static List<DiscountRule> discountRuleList = new ArrayList<>();

    static{
        discountRuleList.add(new MovieSpecialCodeRule(true,20));
        discountRuleList.add(new ShowingSequenceRule(1,false,3));
        discountRuleList.add(new ShowingSequenceRule(2,false,2));
        discountRuleList.add(new ShowStartTimingRule(LocalDateTime.now(),LocalDateTime.now(),true,25));
        discountRuleList.add(new ShowingDateRule(LocalDateTime.now(),false,3));
    }

    public static double getMaxDiscount(Movie movie, Showing showing){
        double maxDiscount = 0.0;

        for(DiscountRule discountRule:discountRuleList){
            maxDiscount = Math.max(maxDiscount,discountRule.getDiscount(movie, showing));
        }

        return maxDiscount;

    }


}
