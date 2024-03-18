package com.ldbbank.referal.Model.Report;

import lombok.Data;

@Data
public class ReportGroupTxnCNY {

    ReportGroupTxnRes CNY;

    @Override
    public String toString() {
        return "ReportGroupTxnCNY{" +
                "CNY=" + CNY +
                '}';
    }
}
