package com.ldbbank.referal.Model.Report;

import lombok.Data;

@Data
public class ReportInfoRes {
    private String name;
    private String id;
    private String totalRef;
    private String totalOwnTxn;
    private String totalRefTxn;
    private String totalAllTxn;

    @Override
    public String toString() {
        return "ReportInfoRes{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", totalRef='" + totalRef + '\'' +
                ", totalOwnTxn='" + totalOwnTxn + '\'' +
                ", totalRefTxn='" + totalRefTxn + '\'' +
                ", totalAllTxn='" + totalAllTxn + '\'' +
                '}';
    }
}
