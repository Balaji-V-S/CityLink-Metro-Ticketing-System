package com.citylink.models;

import com.citylink.models.TapLogs;

import java.time.LocalTime;
import java.util.List;

public class NightDiscount implements FareRule {
    private boolean enabled = true;

    @Override
    public double apply(TapLogs currentTap, List<TapLogs> history, double currentFare) {
        if (!enabled) return currentFare;

        LocalTime time = currentTap.getDataTime().toLocalTime();
        if (time.isAfter(LocalTime.of(21, 59)) && time.isBefore(LocalTime.MIDNIGHT)) {
            return currentFare * 0.8;
        }
        return currentFare;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }

    @Override
    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}

