package com.ldbbank.referal.Model;

import lombok.Data;

import java.util.List;

@Data
public class ReportByTicketRes {
    ReportByTicket totalTicket;
    List<ReportByTicket> saleTicketByGroup;


    @Override
    public String toString() {
        return "ReportByTicketRes{" +
                "totalTicket=" + totalTicket +
                ", saleTicketByGroup=" + saleTicketByGroup +
                '}';
    }
}
