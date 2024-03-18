package com.ldbbank.referal.RowMapper;

import com.ldbbank.referal.Model.GetRefOut;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class GetRefOutMapper  implements RowMapper {
    @Override
    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
        GetRefOut data = new GetRefOut();

        try {

            data.setLdbRef(rs.getString("FT"));
            data.setBookingId(rs.getString("TICKET_CODE"));
            data.setEvenCode(rs.getString("EVENT_CODE"));
            data.setDateBooking(rs.getString("CORE_DATE"));

        }catch (Exception e){
            e.printStackTrace();
            return data;
        }

        return data;
    }
}
