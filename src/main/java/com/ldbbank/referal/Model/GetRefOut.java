package com.ldbbank.referal.Model;

import lombok.Data;

@Data
public class GetRefOut {
    private String evenCode;
    private String bookingId;
    private String ldbRef;

    private String dateBooking;

    @Override
    public String toString() {
        return "GetRefOut{" +
                "evenCode='" + evenCode + '\'' +
                ", bookingId='" + bookingId + '\'' +
                ", ldbRef='" + ldbRef + '\'' +
                ", dateBooking='" + dateBooking + '\'' +
                '}';
    }
}
