package com.ldbbank.referal.Model.ReportEven;

import lombok.Data;

@Data
public class ReportEventReq {
    private String startDate;
    private String endDate;


    @Override
    public String toString() {
        return "ReportEventReq{" +
                "startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                '}';
    }
}
