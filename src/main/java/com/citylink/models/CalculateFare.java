package com.citylink.models;
import com.citylink.models.*;
import com.citylink.utility.RuleConfig;

import java.util.ArrayList;
import java.util.List;

public class CalculateFare {
    private final List<FareRule> rules = new ArrayList<>();

    public CalculateFare(RuleConfig config) {
        BaseFareRule baseFare = new BaseFareRule();
        baseFare.setEnabled(config.baseFareRuleEnabled);
        rules.add(baseFare);

        PeakFareRule peakFare = new PeakFareRule();
        peakFare.setEnabled(config.peakFareRuleEnabled);
        rules.add(peakFare);

        TransferRule transfer = new TransferRule();
        transfer.setEnabled(config.transferRuleEnabled);
        rules.add(transfer);

        NightDiscount night = new NightDiscount();
        night.setEnabled(config.nightDiscountRuleEnabled);
        rules.add(night);

        PostMidnightRule postMidnight = new PostMidnightRule();
        postMidnight.setEnabled(config.postMidnightRuleEnabled);
        rules.add(postMidnight);
    }

    public double calculateFare(TapLogs currentTap, List<TapLogs> history) {
        double fare=0.0;
        for (FareRule rule : rules) {
            fare = rule.apply(currentTap, history, fare);
        }
        return fare;
    }
}
