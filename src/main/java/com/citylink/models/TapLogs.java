package com.citylink.models;
import java.time.LocalDateTime;

public class TapLogs {
    private LocalDateTime dataTime;
    private String line;
    private double fare;
    private String stationCode;

    public TapLogs() {
    }

    public TapLogs(LocalDateTime dataTime, String line, double fare, String stationCode) {
        this.dataTime = dataTime;
        this.line = line;
        this.fare = fare;
        this.stationCode = stationCode;
    }

    public LocalDateTime getDataTime() {
        return dataTime;
    }

    public void setDataTime(LocalDateTime dataTime) {
        this.dataTime = dataTime;
    }

    public String getLine() {
        return line;
    }

    public void setLine(String line) {
        this.line = line;
    }

    public double getFare() {
        return fare;
    }

    public void setFare(double fare) {
        this.fare = fare;
    }

    public String getStationCode() {
        return stationCode;
    }

    public void setStationCode(String stationCode) {
        this.stationCode = stationCode;
    }

    @Override
    public String toString() {
        return "TapLogs{" +
                "dataTime=" + dataTime +
                ", line=" + line +
                ", fare=" + fare +
                ", stationCode='" + stationCode + '\'' +
                '}';
    }
}
