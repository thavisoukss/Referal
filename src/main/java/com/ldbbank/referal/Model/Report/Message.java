package com.ldbbank.referal.Model.Report;

import lombok.Data;

@Data
public class Message {
    private String code;
    private String detail;

    @Override
    public String toString() {
        return "Message{" +
                "code='" + code + '\'' +
                ", detail='" + detail + '\'' +
                '}';
    }
}
