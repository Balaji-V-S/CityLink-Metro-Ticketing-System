package com.citylink.services;


import com.citylink.models.TapLogs;

import java.util.List;

public interface LogsService {
    void addLog(TapLogs log);
    List<TapLogs> getAllLogs();
}
