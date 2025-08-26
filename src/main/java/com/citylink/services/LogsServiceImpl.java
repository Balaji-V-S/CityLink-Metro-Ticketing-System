package com.citylink.services;

import com.citylink.dao.LogsDAO;
import com.citylink.dao.LogsDAOImpl;
import com.citylink.models.TapLogs;

import java.util.List;

public class LogsServiceImpl implements LogsService{

    LogsDAO logsdao=new LogsDAOImpl();
    List<TapLogs> oldLogs;

    @Override
    public void addLog(TapLogs log) {
        logsdao.addLog(log);
    }

    @Override
    public List<TapLogs> getAllLogs() {
        oldLogs=logsdao.getAllLogs();
        return oldLogs;
    }
}
