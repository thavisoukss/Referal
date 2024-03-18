package com.ldbbank.referal.Model.Report;

import lombok.Data;

@Data
public class ReportGroupTxnUSD {

    ReportGroupTxnRes USD;

    @Override
    public String toString() {
        return "ReportGroupTxnUSD{" +
                "USD=" + USD +
                '}';
    }
}
