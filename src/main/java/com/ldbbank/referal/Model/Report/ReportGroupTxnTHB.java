package com.ldbbank.referal.Model.Report;

import lombok.Data;

@Data
public class ReportGroupTxnTHB {

    ReportGroupTxnRes THB;

    @Override
    public String toString() {
        return "ReportGroupTxnTHB{" +
                "THB=" + THB +
                '}';
    }
}
