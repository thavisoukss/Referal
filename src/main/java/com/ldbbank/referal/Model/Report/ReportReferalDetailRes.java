package com.ldbbank.referal.Model.Report;

import lombok.Data;

@Data
public class ReportReferalDetailRes {
    public  String code;
    public String  customerMobile;
    public String customerName;
    public String totalTxn;
    public String totalAmount;

    @Override
    public String toString() {
        return "ReportReferalDetailRes{" +
                "code='" + code + '\'' +
                ", customerMobile='" + customerMobile + '\'' +
                ", customerName='" + customerName + '\'' +
                ", totalTxn='" + totalTxn + '\'' +
                ", totalAmount='" + totalAmount + '\'' +
                '}';
    }
}
