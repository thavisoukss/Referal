package com.ldbbank.referal.RowMapper;

import com.ldbbank.referal.Model.Report.ReportInfoRes;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ReportInfoMapper  implements RowMapper {
    @Override
    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {

        ReportInfoRes data = new ReportInfoRes();

        try {

           data.setId(rs.getString("STAFT_CODE"));
           data.setName(rs.getString("NAME"));
            data.setTotalAllTxn(rs.getString("TOTAL_TXN"));
            data.setTotalRef(rs.getString("OWN_REF"));
            data.setTotalRefTxn(rs.getString("REFERAL_TXN"));
            data.setTotalOwnTxn(rs.getString("OWN_TXN"));


        }catch (Exception e){
            e.printStackTrace();
            return data;
        }
        return data;
    }
}
