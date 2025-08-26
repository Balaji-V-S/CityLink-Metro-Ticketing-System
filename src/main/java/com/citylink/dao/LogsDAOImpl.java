package com.citylink.dao;

import com.citylink.models.TapLogs;
import java.util.ArrayList;
import java.util.List;

public class LogsDAOImpl implements LogsDAO {
    private List<TapLogs> logs = new ArrayList<TapLogs>();

    @Override
    public void addLog(TapLogs log) {
        logs.add((log));
    }

    @Override
    public List<TapLogs> getAllLogs() {
        return logs;
    }
}
