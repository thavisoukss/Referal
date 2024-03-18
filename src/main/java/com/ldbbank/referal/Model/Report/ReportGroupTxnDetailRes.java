package com.ldbbank.referal.Model.Report;

import lombok.Data;

@Data
public class ReportGroupTxnDetailRes {
    ReportGroupTxnLAK LAK;
    ReportGroupTxnTHB THB;
    ReportGroupTxnUSD USD;
    ReportGroupTxnCNY CNY;

    @Override
    public String toString() {
        return "ReportGroupTxnDetailRes{" +
                "LAK=" + LAK +
                ", THB=" + THB +
                ", USD=" + USD +
                ", CNY=" + CNY +
                '}';
    }
}
