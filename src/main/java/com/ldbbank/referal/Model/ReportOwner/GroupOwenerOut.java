package com.ldbbank.referal.Model.ReportOwner;

import lombok.Data;

@Data
public class GroupOwenerOut {
    private String date;
    private String code;
    private String name;
    private String debbit;
    private String credit;
    private String totalAccount;
    private String closingBalance;
    private String calClosingBalance;
    private String totalTxn;
    private String rate;

    @Override
    public String toString() {
        return "GroupOwenerOut{" +
                "date='" + date + '\'' +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", debbit='" + debbit + '\'' +
                ", credit='" + credit + '\'' +
                ", totalAccount='" + totalAccount + '\'' +
                ", closingBalance='" + closingBalance + '\'' +
                ", calClosingBalance='" + calClosingBalance + '\'' +
                ", totalTxn='" + totalTxn + '\'' +
                ", rate='" + rate + '\'' +
                '}';
    }
}
