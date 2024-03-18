package com.ldbbank.referal.Model;

import lombok.Data;

@Data
public class ReportByTicket {
    private String date;
    private String allTicket;
    private String toatalAmount;
    private String allTransaction;


    @Override
    public String toString() {
        return "ReportByTicket{" +
                "date='" + date + '\'' +
                ", allTicket='" + allTicket + '\'' +
                ", toatalAmount='" + toatalAmount + '\'' +
                ", allTransaction='" + allTransaction + '\'' +
                '}';
    }
}
