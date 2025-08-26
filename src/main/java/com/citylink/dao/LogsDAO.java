package com.citylink.dao;

import com.citylink.models.TapLogs;
import java.util.List;

public interface LogsDAO {
    void addLog(TapLogs log);
    List<TapLogs> getAllLogs();
}
