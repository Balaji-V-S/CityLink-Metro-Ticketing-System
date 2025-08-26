package com.citylink.models;
import com.citylink.models.TapLogs;

import java.time.Duration;
import java.util.List;

public class TransferRule implements FareRule {
    private boolean enabled = true;

    @Override
    public double apply(TapLogs currentTap, List<TapLogs> history, double currentFare) {
        if (!enabled || history.isEmpty()) return currentFare;

        TapLogs lastTap = history.get(history.size() - 1);
        Duration diff = Duration.between(lastTap.getDataTime().toLocalTime(), currentTap.getDataTime().toLocalTime());

        if (diff.toMinutes() <= 30 && !lastTap.getLine().equals(currentTap.getLine())) {
            return 0.0;
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
