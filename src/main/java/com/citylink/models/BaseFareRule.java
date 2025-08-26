package com.citylink.models;
import com.citylink.models.TapLogs;

import java.util.List;

public class BaseFareRule implements FareRule {
    private boolean enabled = true;

    @Override
    public double apply(TapLogs currentTap, List<TapLogs> history, double currentFare) {
        return enabled ? 25.0 : currentFare;
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

