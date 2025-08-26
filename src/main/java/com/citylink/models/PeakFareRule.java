package com.citylink.models;

import com.citylink.models.TapLogs;

import java.time.LocalTime;
import java.util.List;

public class PeakFareRule implements FareRule {
    private boolean enabled = true;

    @Override
    public double apply(TapLogs currentTap, List<TapLogs> history, double currentFare) {
        if (!enabled) return currentFare;

        LocalTime time = currentTap.getDataTime().toLocalTime();
        if ((time.isAfter(LocalTime.of(7, 59)) && time.isBefore(LocalTime.of(10, 1))) ||
                (time.isAfter(LocalTime.of(17, 59)) && time.isBefore(LocalTime.of(20, 1)))) {
            return currentFare*1.5;
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
