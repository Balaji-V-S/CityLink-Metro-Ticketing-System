package com.citylink.models;
import com.citylink.models.TapLogs;

import java.time.LocalTime;
import java.util.List;

public class PostMidnightRule implements FareRule {
    private boolean enabled = true;

    @Override
    public double apply(TapLogs currentTap, List<TapLogs> history, double currentFare) {
        if (!enabled) return currentFare;

        LocalTime time = currentTap.getDataTime().toLocalTime();
        if (time.isAfter(LocalTime.MIDNIGHT.minusSeconds(1)) && time.isBefore(LocalTime.of(4, 0))) {
            return currentFare * 0.65;
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
