package com.ldbbank.referal.Dao.Report;

import com.ldbbank.referal.Model.GetRefOut;
import com.ldbbank.referal.Model.GetRefReq;
import com.ldbbank.referal.Model.Report.ReportGroupTxnRes;
import com.ldbbank.referal.Model.Report.ReportInfoReq;
import com.ldbbank.referal.Model.Report.ReportInfoRes;
import com.ldbbank.referal.Model.Report.ReportReferalDetailRes;
import com.ldbbank.referal.Model.ReportByTicket;
import com.ldbbank.referal.Model.ReportEven.ReportEventOut;
import com.ldbbank.referal.Model.ReportEven.ReportEventReq;
import com.ldbbank.referal.Model.ReportOwner.GroupOwenerOut;
import com.ldbbank.referal.Model.ReportOwner.GroupOwnerReq;
import com.ldbbank.referal.RowMapper.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ImpReportDao  implements ReportDao{

    private static final Logger logger = LogManager.getLogger(ImpReportDao.class);

    @Autowired
    @Qualifier("EBankJdbcTemplate")
    private JdbcTemplate EBankJdbcTemplate;

    @Override
    public List<ReportInfoRes> getReportInfo(ReportInfoReq req) {

        List<ReportInfoRes> result = new ArrayList<>();

        try {

String SQL = " SELECT   'KPV' as  NAME , 'KPV' as  STAFT_CODE  , OWN_REF ,  OWN_TXN , REFERAL_TXN ,  REFERAL_TXN + OWN_TXN AS TOTAL_TXN  FROM (\n" +
        "SELECT  NVL(COUNT(*),0) AS OWN_REF  FROM REFERAL_CASHBACK WHERE STAFT_CODE = 'KPV'  ) T1,\n" +
        "(SELECT   NVL (COUNT (*),0) AS OWN_TXN  FROM  REFERAL_CASHBACK_VIEW WHERE   STAFT_CODE = 'KPV_OWN' ) T2,\n" +
        "( SELECT    NVL(COUNT(*),0) AS REFERAL_TXN  FROM  REFERAL_CASHBACK_VIEW WHERE   STAFT_CODE = 'KPV'  ) T3";
logger.info(SQL);

result = EBankJdbcTemplate.query(SQL , new ReportInfoMapper());

logger.info("************************** show object report information **********************");
logger.info(result);

        }catch (Exception e){
            e.printStackTrace();
            return result;
        }

        return result;
    }

    @Override
    public List<ReportGroupTxnRes> getReportGroupTxn(ReportInfoReq req) {

        List<ReportGroupTxnRes> result = new ArrayList<>();

        try {

            String SQL = " SELECT OWN_AMOUNT , REFERAL_AMOUNT ,  OWN_AMOUNT +  REFERAL_AMOUNT AS TOTAL_AMOUNT FROM \n" +
                    "(  SELECT  NVL (SUM (AMOUNT),0) AS OWN_AMOUNT  FROM  REFERAL_CASHBACK_VIEW WHERE   STAFT_CODE = 'KPV_OWN'  )  T2,\n" +
                    "(SELECT   NVL (SUM (AMOUNT),0) AS REFERAL_AMOUNT  FROM  REFERAL_CASHBACK_VIEW WHERE   STAFT_CODE = 'KPV' ) T3 ";

            logger.info(SQL);

            logger.info("************************** show object report group transaction  **********************");
            logger.info(result);

            result = EBankJdbcTemplate.query(SQL , new ReportGroupTxnMapper());

        }catch (Exception e){
            e.printStackTrace();
            return result;
        }
        return result;
    }

    @Override
    public List<ReportGroupTxnRes> getReportGroupTxnByCcy(ReportInfoReq req, String ccy) {

        List<ReportGroupTxnRes> result = new ArrayList<>();

        try {

            String SQL = "  SELECT OWN_AMOUNT , REFERAL_AMOUNT ,  OWN_AMOUNT +  REFERAL_AMOUNT AS TOTAL_AMOUNT FROM \n" +
                    "(  SELECT  NVL (SUM (AMOUNT),0) AS OWN_AMOUNT  FROM  REFERAL_CASHBACK_VIEW WHERE   STAFT_CODE = 'KPV_OWN'  AND FROM_ACCOUNT_CCY =  '"+ccy+"' )  T2,\n" +
                    "(SELECT   NVL (SUM (AMOUNT),0) AS REFERAL_AMOUNT  FROM  REFERAL_CASHBACK_VIEW WHERE   STAFT_CODE = 'KPV'  AND FROM_ACCOUNT_CCY =  '"+ccy+"'  ) T3 ";
            logger.info(SQL);

            logger.info("************************** show object report group transaction  by currency  **********************");
            logger.info(result);

            result = EBankJdbcTemplate.query(SQL , new ReportGroupTxnMapper());

        }catch (Exception e){
            e.printStackTrace();
            return result;
        }
        return result;
    }

    @Override
    public List<ReportReferalDetailRes> getReferalDetail(ReportInfoReq req) {

        List<ReportReferalDetailRes> result = new ArrayList<>();

        try {

            String SQL = " SELECT  T1.STAFT_CODE , T1.CUST_MOBILE , T1.CUST_NAME_EN AS CUST_NAME_LO , COUNT(*) AS TOTAL_TXN , SUM(AMOUNT) AS TOTAL_AMOUNT  FROM REFERAL_CASHBACK  T1\n" +
                    "INNER JOIN REFERAL_CASHBACK_VIEW T2 ON T1.CUST_MOBILE = T2.USER_ID WHERE TRUNC(T2.TXN_DATE) BETWEEN\n" +
                    "TO_DATE('2021-01-13', 'YYYY-MM-DD') AND TO_DATE('2024-03-14', 'YYYY-MM-DD') AND T1.STAFT_CODE = 'KPV'  GROUP BY T1.STAFT_CODE , T1.CUST_MOBILE , T1.CUST_NAME_EN ";

            logger.info(SQL);

            logger.info("************************** show object report  detail *********************");
            logger.info(result);
            result = EBankJdbcTemplate.query(SQL , new ReportReferalDetailMapper());

        }catch (Exception e){
            e.printStackTrace();
            return result;
        }
        return result;
    }

    @Override
    public List<GroupOwenerOut> getGroupOwner(GroupOwnerReq req) {

        List<GroupOwenerOut> result = new ArrayList<>();

        String ownDate = req.getStartDate()+"-"+req.getEndDate();

        try {

            String SQL = " SELECT T1.DATES AS DATES , CUST_NAME_EN , 'KPV' AS CODE, SUM_CREDIT , SUM_DEBIT ,  SUM_CLOSING_BALANCE ,TOTAL_ACCOUNT , CAL_CLOSING_BALANCE , TOTAL_TXN , TOTAL_RATE FROM\n" +
                    "(SELECT TOTAL_ACCOUNT FROM (\n" +
                    "SELECT COUNT(*) AS TOTAL_ACCOUNT  FROM REPORT_REFERRAL WHERE CODE = 'KPV_OWN' GROUP BY ACCOUNT_NO ) WHERE ROWNUM = 1),\n" +
                    "( SELECT SUM(CLOSING_BALANCE)  , '"+ownDate+"'  AS DATES ,   SUM(CLOSING_BALANCE) / 2 AS CAL_CLOSING_BALANCE FROM  REPORT_REFERRAL WHERE CODE = 'KPV_OWN' AND TRUNC(TXN_DATE) = TO_DATE('"+req.getEndDate()+"', 'YYYY-MM-DD')) T1,\n" +
                    "(\n" +
                    "SELECT  SUM(TOTAL_CREDIT) AS SUM_CREDIT , SUM(TOTAL_DEBIT) AS SUM_DEBIT , SUM(CLOSING_BALANCE)  AS SUM_CLOSING_BALANCE  , 'ບໍລິສັດ ຄຳພູວົງ'  AS CUST_NAME_EN  , SUM(NVL(TOTAL_AMT,0)) AS TOTAL_TXN  , SUM(TOTAL_RATE) AS TOTAL_RATE FROM REPORT_REFERRAL WHERE CODE = 'KPV_OWN'\n" +
                    "AND TRUNC(TXN_DATE) BETWEEN  TO_DATE('"+req.getStartDate()+"', 'YYYY-MM-DD') AND TO_DATE('"+req.getEndDate()+"', 'YYYY-MM-DD') ) T2 ";

            logger.info(SQL);
            result = EBankJdbcTemplate.query(SQL , new GroupOwnerOutMapper());

        }catch (Exception e){
            e.printStackTrace();
            return result;
        }
        return result;
    }

    @Override
    public List<GroupOwenerOut> getGroupPatner(GroupOwnerReq req) {
        List<GroupOwenerOut> result = new ArrayList<>();

        String ownDate = req.getStartDate()+"-"+req.getEndDate();

        try {

            String SQL = " SELECT T1.DATES AS DATES , CUST_NAME_EN , 'KPV' AS CODE, SUM_CREDIT , SUM_DEBIT ,  SUM_CLOSING_BALANCE ,TOTAL_ACCOUNT , CAL_CLOSING_BALANCE ,TOTAL_TXN , TOTAL_RATE  FROM\n" +
                    "(SELECT TOTAL_ACCOUNT FROM (\n" +
                    "SELECT COUNT(*) AS TOTAL_ACCOUNT  FROM REPORT_REFERRAL WHERE CODE = 'KPV' GROUP BY ACCOUNT_NO ) WHERE ROWNUM = 1) ,\n" +
                    "( SELECT SUM(CLOSING_BALANCE)  , '"+ownDate+"'  AS DATES , SUM(CLOSING_BALANCE) / 2 AS CAL_CLOSING_BALANCE FROM  REPORT_REFERRAL WHERE CODE = 'KPV' AND TRUNC(TXN_DATE) = TO_DATE('"+req.getEndDate()+"', 'YYYY-MM-DD')) T1,\n" +
                    "(\n" +
                    "SELECT  SUM(TOTAL_CREDIT) AS SUM_CREDIT , SUM(TOTAL_DEBIT) AS SUM_DEBIT , SUM(CLOSING_BALANCE)  AS SUM_CLOSING_BALANCE  , 'ຄູ່ຄ້າ ຄຳພູວົງ'  AS CUST_NAME_EN ,  SUM(NVL(TOTAL_AMT,0)) AS TOTAL_TXN  , SUM(TOTAL_RATE) AS TOTAL_RATE  FROM REPORT_REFERRAL WHERE CODE = 'KPV'\n" +
                    "AND TRUNC(TXN_DATE) BETWEEN  TO_DATE('"+req.getStartDate()+"', 'YYYY-MM-DD') AND TO_DATE('"+req.getEndDate()+"', 'YYYY-MM-DD') ) T2";

            logger.info(SQL);
            result = EBankJdbcTemplate.query(SQL , new GroupOwnerOutMapper());

        }catch (Exception e){
            e.printStackTrace();
            return result;
        }
        return result;
    }

    @Override
    public List<GroupOwenerOut> getPatnerDetail(GroupOwnerReq req) {
        List<GroupOwenerOut> result = new ArrayList<>();

        String ownDate = req.getStartDate()+"-"+req.getEndDate();
        try {

            String SQL = " SELECT T1.DATES AS DATES , CUST_NAME_EN , STAFT_CODE AS CODE, SUM_CREDIT , SUM_DEBIT ,  SUM_CLOSING_BALANCE ,TOTAL_ACCOUNT , CAL_CLOSING_BALANCE ,TOTAL_TXN  ,  TOTAL_RATE   FROM\n" +
                    "( SELECT SUM(CLOSING_BALANCE)  , '"+ownDate+"' AS DATES    FROM  REPORT_REFERRAL WHERE CODE = 'KPV' AND TRUNC(TXN_DATE) = TO_DATE('"+req.getEndDate()+"', 'YYYY-MM-DD')) T1,\n" +
                    "(\n" +
                    "SELECT  COUNT(*) AS TOTAL_ACCOUNT , SUM(TOTAL_CREDIT) AS SUM_CREDIT , STAFT_CODE, SUM(TOTAL_DEBIT) AS SUM_DEBIT , SUM(CLOSING_BALANCE)  AS SUM_CLOSING_BALANCE, SUM(CLOSING_BALANCE) / 2 AS CAL_CLOSING_BALANCE  , CUST_NAME_EN , SUM(NVL(TOTAL_AMT,0)) AS TOTAL_TXN  , SUM(TOTAL_RATE) AS TOTAL_RATE   FROM REPORT_REFERRAL WHERE CODE = 'KPV'\n" +
                    "AND TRUNC(TXN_DATE) BETWEEN  TO_DATE('"+req.getStartDate()+"', 'YYYY-MM-DD') AND TO_DATE('"+req.getEndDate()+"', 'YYYY-MM-DD') GROUP BY CUST_NAME_EN , STAFT_CODE) T2 ";

            logger.info(SQL);
            result = EBankJdbcTemplate.query(SQL , new GroupOwnerOutMapper());

        }catch (Exception e){
            e.printStackTrace();
            return result;
        }
        return result;
    }

    @Override
    public List<GetRefOut> getRef(GetRefReq req) {

        List<GetRefOut> result = new ArrayList<>();

        try {

            String SQL = " SELECT EVENT_CODE , TICKET_CODE , FT , CORE_DATE FROM TRUST_EVENT_REG_HIS WHERE FT =  '"+req.getRef()+"'  AND REG_STATUS = 'A' ";

            logger.info(SQL);
            result = EBankJdbcTemplate.query(SQL , new GetRefOutMapper());

        }catch (Exception e){
            e.printStackTrace();
            return result;
        }
        return result;
    }

    @Override
    public List<ReportEventOut> getReportEvent(ReportEventReq req) {

        List<ReportEventOut> result = new ArrayList<>();

        try {

            String SQL = " SELECT  CUST_ACC_NO , CUST_ACC_NAME , CUST_ACC_CCY , CORE_DATE , AMOUNT , TICKET_PRICE , FT , EVENT_CODE , CUST_TEL , REG_STATUS , TICKET_CODE  FROM TRUST_EVENT_REG_HIS  WHERE TRUNC(CORE_DATE) BETWEEN  TO_DATE('"+req.getStartDate()+"', 'YYYY-MM-DD') AND TO_DATE('"+req.getEndDate()+"', 'YYYY-MM-DD')  AND REG_STATUS ='A' ORDER BY ID DESC " ;
            logger.info(SQL);
            result = EBankJdbcTemplate.query(SQL , new ReportEventOutMapper());

        }catch (Exception e){
            e.printStackTrace();
            return  result;
        }
        return  result;
    }

    @Override
    public List<ReportByTicket> getAllTicket() {

        List<ReportByTicket> result = new ArrayList<>();

        try {

            String SQL = " SELECT  sum(AMOUNT) AS TOTAL_AMOUNT ,  SUM(QTY) AS ALL_TICKET , COUNT(*) AS TXN , '' as  DATE_AT FROM TRUST_EVENT_REG_HIS where REG_STATUS = 'A' and FT is not null ";
            logger.info(SQL);
            result = EBankJdbcTemplate.query(SQL , new ReportByTicketMapper ());


        }catch (Exception e){
            e.printStackTrace();
            return  result;
        }
        return  result;
    }

    @Override
    public List<ReportByTicket> getGroupTicket() {
        List<ReportByTicket> result = new ArrayList<>();

        try {

            String SQL = " SELECT    sum(AMOUNT) AS TOTAL_AMOUNT ,  SUM(QTY) AS ALL_TICKET , COUNT(*) AS TXN  ,  TO_CHAR(CORE_DATE,'YYYY-MM-DD')  AS DATE_AT  FROM TRUST_EVENT_REG_HIS  where REG_STATUS = 'A' and FT is not null  GROUP BY TO_CHAR(CORE_DATE,'YYYY-MM-DD') order by  DATE_AT desc";
            logger.info(SQL);
            result = EBankJdbcTemplate.query(SQL , new ReportByTicketMapper ());


        }catch (Exception e){
            e.printStackTrace();
            return  result;
        }
        return  result;
    }
}
