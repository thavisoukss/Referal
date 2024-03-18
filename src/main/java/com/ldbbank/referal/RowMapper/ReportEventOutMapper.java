package com.ldbbank.referal.RowMapper;

import com.ldbbank.referal.Model.ReportEven.ReportEventOut;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ReportEventOutMapper implements RowMapper {
    @Override
    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {

        ReportEventOut data = new ReportEventOut();

        try {
            data.setFromAccount(rs.getString("CUST_ACC_NO"));
            data.setCustomerName(rs.getString("CUST_ACC_NAME"));
            data.setFromCcy(rs.getString("CUST_ACC_CCY"));
            data.setBookDate(rs.getString("CORE_DATE"));
            data.setTotalAmount(rs.getString("AMOUNT"));
            data.setPrice(rs.getString("TICKET_PRICE"));
            data.setFt(rs.getString("FT"));
            data.setEvenCode(rs.getString("EVENT_CODE"));
            data.setMobile(rs.getString("CUST_TEL"));
            data.setStatus(rs.getString("REG_STATUS"));
            data.setTicketCode(rs.getString("TICKET_CODE"));

             return data;
        }catch (Exception e){
            e.printStackTrace();
        }
        return data;
    }
}
