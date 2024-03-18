package com.ldbbank.referal.Model.Report;

import lombok.Data;

@Data
public class ReportTotalAmount {

    private String id;
    private String totalRef;
    private String totalOwnTxn;
    private String totalRefTxn;
    private String totalAllTxn;

    @Override
    public String toString() {
        return "ReportTotalAmount{" +
                "id='" + id + '\'' +
                ", totalRef='" + totalRef + '\'' +
                ", totalOwnTxn='" + totalOwnTxn + '\'' +
                ", totalRefTxn='" + totalRefTxn + '\'' +
                ", totalAllTxn='" + totalAllTxn + '\'' +
                '}';
    }
}
