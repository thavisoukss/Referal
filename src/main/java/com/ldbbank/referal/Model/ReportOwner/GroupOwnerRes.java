package com.ldbbank.referal.Model.ReportOwner;

import lombok.Data;

import java.util.List;

@Data
public class GroupOwnerRes {
    GroupOwenerOut groupOwener;
    GroupOwenerOut groupPatner;
    List<GroupOwenerOut> paterList;

    @Override
    public String toString() {
        return "GroupOwnerRes{" +
                "groupOwener=" + groupOwener +
                ", groupPatner=" + groupPatner +
                ", paterList=" + paterList +
                '}';
    }
}
