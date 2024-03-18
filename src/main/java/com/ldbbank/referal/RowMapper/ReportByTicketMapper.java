package com.ldbbank.referal.RowMapper;

import com.ldbbank.referal.Model.ReportByTicket;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ReportByTicketMapper  implements RowMapper {

    @Override
    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {

        ReportByTicket data = new ReportByTicket();

        try {

            data.setDate(rs.getString("DATE_AT"));
            data.setAllTicket(rs.getString("ALL_TICKET"));
            data.setAllTransaction(rs.getString("TXN"));
            data.setToatalAmount(rs.getString("TOTAL_AMOUNT"));


        }catch (Exception e){
            e.printStackTrace();
            return data;
        }
        return data;
    }
}
