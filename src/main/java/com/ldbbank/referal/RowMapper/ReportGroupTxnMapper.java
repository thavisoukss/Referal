package com.ldbbank.referal.RowMapper;

import com.ldbbank.referal.Model.Report.ReportGroupTxnRes;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ReportGroupTxnMapper implements RowMapper {
    @Override
    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {

        ReportGroupTxnRes data = new ReportGroupTxnRes();

        try {

            data.setOwnAmount(rs.getString("OWN_AMOUNT"));
            data.setRefAmount(rs.getString("REFERAL_AMOUNT"));
            data.setTotalAmount(rs.getString("TOTAL_AMOUNT"));

        }catch (Exception e){
            e.printStackTrace();
            return data;
        }
        return data;
    }
}
