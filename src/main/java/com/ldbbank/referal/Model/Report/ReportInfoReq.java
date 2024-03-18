package com.ldbbank.referal.Model.Report;

import lombok.Data;

@Data
public class ReportInfoReq {
    private String partNerId;
    private String startDate;
    private String endDate;

    @Override
    public String toString() {
        return "ReportReq{" +
                "partNerId='" + partNerId + '\'' +
                ", startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                '}';
    }
}
