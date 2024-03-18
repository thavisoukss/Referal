package com.ldbbank.referal.Model.Report;

import lombok.Data;

@Data
public class ReportGroupTxnRes {

    public String ownAmount;
    public String refAmount;
    public String totalAmount;


    @Override
    public String toString() {
        return "ReportGroupTxnRes{" +
                "ownAmount='" + ownAmount + '\'' +
                ", refAmount='" + refAmount + '\'' +
                ", totalAmount='" + totalAmount + '\'' +
                '}';
    }
}
