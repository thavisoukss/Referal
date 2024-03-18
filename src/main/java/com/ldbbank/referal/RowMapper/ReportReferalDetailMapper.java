package com.ldbbank.referal.RowMapper;

import com.ldbbank.referal.Model.Report.ReportReferalDetailRes;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ReportReferalDetailMapper implements RowMapper {
    @Override
    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {

        ReportReferalDetailRes data = new ReportReferalDetailRes();

        try {

            data.setCode(rs.getString("STAFT_CODE"));
            data.setCustomerName(rs.getString("CUST_NAME_LO"));
            data.setTotalTxn(rs.getString("TOTAL_TXN"));
            data.setTotalAmount(rs.getString("TOTAL_AMOUNT"));
            data.setCustomerMobile(rs.getString("CUST_MOBILE"));
        }catch (Exception e){
            e.printStackTrace();
            return data;
        }
        return data;
    }
}
