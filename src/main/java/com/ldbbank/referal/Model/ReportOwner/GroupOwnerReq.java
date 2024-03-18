package com.ldbbank.referal.Model.ReportOwner;

import lombok.Data;

@Data
public class GroupOwnerReq {
    private String startDate;
    private String endDate;
    private String company;


    @Override
    public String toString() {
        return "GroupOwnerReq{" +
                "startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                ", company='" + company + '\'' +
                '}';
    }
}
