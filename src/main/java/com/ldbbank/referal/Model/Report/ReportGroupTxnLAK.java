package com.ldbbank.referal.Model.Report;

import lombok.Data;

@Data
public class ReportGroupTxnLAK {
    ReportGroupTxnRes LAK;

    @Override
    public String toString() {
        return "ReportGroupTxnLAK{" +
                "LAK=" + LAK +
                '}';
    }
}
