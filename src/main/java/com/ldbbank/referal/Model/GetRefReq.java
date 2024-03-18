package com.ldbbank.referal.Model;

import lombok.Data;

@Data
public class GetRefReq {
    private String ref;

    @Override
    public String toString() {
        return "GetRefReq{" +
                "ref='" + ref + '\'' +
                '}';
    }
}
