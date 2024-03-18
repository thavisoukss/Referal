package com.ldbbank.referal.RowMapper;

import com.ldbbank.referal.Model.ReportOwner.GroupOwenerOut;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class GroupOwnerOutMapper  implements RowMapper {
    @Override
    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {

        GroupOwenerOut data = new GroupOwenerOut();

        try {
            data.setDate(rs.getString("DATES"));
            data.setName(rs.getString("CUST_NAME_EN"));
            data.setCode(rs.getString("CODE"));
            data.setDebbit(rs.getString("SUM_DEBIT"));
            data.setCredit(rs.getString("SUM_CREDIT"));
            data.setClosingBalance(rs.getString("SUM_CLOSING_BALANCE"));
            data.setCalClosingBalance(rs.getString("CAL_CLOSING_BALANCE"));
            data.setTotalAccount(rs.getString("TOTAL_ACCOUNT"));
            data.setTotalTxn(rs.getString("TOTAL_TXN"));
            data.setRate(rs.getString("TOTAL_RATE"));

            return data;

        }catch (Exception e){
            e.printStackTrace();
            return data;
        }

    }
}
