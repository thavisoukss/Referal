package com.ldbbank.referal.Model.ReportEven;

import lombok.Data;

@Data
public class ReportEventOut {

    private String fromAccount;
    private String customerName;
    private String fromCcy;
    private String bookDate;
    private String TotalAmount;
    private String price;
    private String ft;
    private String evenCode;
    private String mobile;
    private String status;
    private String ticketCode;


    @Override
    public String toString() {
        return "ReportEventOut{" +
                "fromAccount='" + fromAccount + '\'' +
                ", customerName='" + customerName + '\'' +
                ", fromCcy='" + fromCcy + '\'' +
                ", bookDate='" + bookDate + '\'' +
                ", TotalAmount='" + TotalAmount + '\'' +
                ", price='" + price + '\'' +
                ", ft='" + ft + '\'' +
                ", evenCode='" + evenCode + '\'' +
                ", mobile='" + mobile + '\'' +
                ", status='" + status + '\'' +
                ", ticketCode='" + ticketCode + '\'' +
                '}';
    }
}
