package com.citylink.models;
import com.citylink.models.TapLogs;

import java.util.List;

public interface FareRule {
    double apply(TapLogs currentTap, List<TapLogs> history, double currentFare);
    boolean isEnabled();
    void setEnabled(boolean enabled);
}
