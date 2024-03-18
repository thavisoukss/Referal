package com.ldbbank.referal.Model;

import com.ldbbank.referal.Model.Report.Message;
import lombok.Data;

@Data
public class GetRefRes {
    Message message;
    GetRefOut data;


    @Override
    public String toString() {
        return "GetRefRes{" +
                "message=" + message +
                ", data=" + data +
                '}';
    }
}
