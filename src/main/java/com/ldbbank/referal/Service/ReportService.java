package com.ldbbank.referal.Service;

import com.ldbbank.referal.Dao.Report.ImpReportDao;
import com.ldbbank.referal.Model.*;
import com.ldbbank.referal.Model.Report.*;
import com.ldbbank.referal.Model.ReportEven.ReportEventOut;
import com.ldbbank.referal.Model.ReportEven.ReportEventReq;
import com.ldbbank.referal.Model.ReportOwner.GroupOwenerOut;
import com.ldbbank.referal.Model.ReportOwner.GroupOwnerReq;
import com.ldbbank.referal.Model.ReportOwner.GroupOwnerRes;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class ReportService {

    private static final Logger logger = LogManager.getLogger(ReportService.class);

    @Autowired
    ImpReportDao impReportDao;



    public List<ReportInfoRes> getReportInfo (ReportInfoReq req){

        List<ReportInfoRes> result = new ArrayList<>();

        try {

            result = impReportDao.getReportInfo(req);

        }catch (Exception e){
            e.printStackTrace();
            return  result;
        }
        return result;
    }

    public List<ReportGroupTxnRes> getReportGroupTxn (ReportInfoReq req){

        List<ReportGroupTxnRes> result = new ArrayList<>();

        try {

            result = impReportDao.getReportGroupTxn(req);

        }catch (Exception e){
            e.printStackTrace();
            return  result;
        }
        return result;
    }

    public ReportGroupTxnDetailRes getReportGroupDetail (ReportInfoReq req ){

        ReportGroupTxnDetailRes result = new ReportGroupTxnDetailRes();

        ReportGroupTxnLAK lak = new ReportGroupTxnLAK();
        ReportGroupTxnTHB thb = new ReportGroupTxnTHB();
        ReportGroupTxnUSD usd = new ReportGroupTxnUSD();
        ReportGroupTxnCNY cny = new ReportGroupTxnCNY();

        ReportGroupTxnRes datalak = new ReportGroupTxnRes();
        ReportGroupTxnRes datathb = new ReportGroupTxnRes();
        ReportGroupTxnRes datausd = new ReportGroupTxnRes();
        ReportGroupTxnRes datacny = new ReportGroupTxnRes();

        List<ReportGroupTxnRes> listlak = new ArrayList<>();
        List<ReportGroupTxnRes> listthb = new ArrayList<>();
        List<ReportGroupTxnRes> listusd = new ArrayList<>();
        List<ReportGroupTxnRes> listcny = new ArrayList<>();

        try {

            logger.info("**************************** get group lak ****************************");

            listlak = impReportDao.getReportGroupTxnByCcy(req , "418");
            datalak.setOwnAmount(listlak.get(0).getOwnAmount());
            datalak.setRefAmount(listlak.get(0).getRefAmount());
            datalak.setTotalAmount(listlak.get(0).getTotalAmount());

            logger.info("**************************** get group thb ****************************");

            listthb = impReportDao.getReportGroupTxnByCcy(req , "764");
            datathb.setOwnAmount(listthb.get(0).getOwnAmount());
            datathb.setRefAmount(listthb.get(0).getRefAmount());
            datathb.setTotalAmount(listthb.get(0).getTotalAmount());

            logger.info("**************************** get group usd ****************************");

            listusd = impReportDao.getReportGroupTxnByCcy(req , "840");
            datausd.setOwnAmount(listusd.get(0).getOwnAmount());
            datausd.setRefAmount(listusd.get(0).getRefAmount());
            datausd.setTotalAmount(listusd.get(0).getTotalAmount());


            logger.info("**************************** get group cny ****************************");

            listcny = impReportDao.getReportGroupTxnByCcy(req , "156");
            datacny.setOwnAmount(listcny.get(0).getOwnAmount());
            datacny.setRefAmount(listcny.get(0).getRefAmount());
            datacny.setTotalAmount(listcny.get(0).getTotalAmount());

            lak.setLAK(datalak);
            thb.setTHB(datathb);
            usd.setUSD(datausd);
            cny.setCNY(datacny);

            result.setLAK(lak);
            result.setTHB(thb);
            result.setUSD(usd);
            result.setCNY(cny);

        }catch (Exception e){
            e.printStackTrace();
            return result;
        }
        return result;
    }

    public List<ReportReferalDetailRes> getReportDetail (ReportInfoReq req){

        List<ReportReferalDetailRes> reslut = new ArrayList<>();

        try {

            reslut = impReportDao.getReferalDetail(req);

        }catch (Exception e){
            e.printStackTrace();
            return reslut;
        }
        return reslut;
    }

    public GroupOwnerRes ReportOwnerGroup (GroupOwnerReq req){

        GroupOwnerRes result = new  GroupOwnerRes();
        GroupOwenerOut groupOwener = new GroupOwenerOut();
        List<GroupOwenerOut> listGroupOwener = new ArrayList<>();
        GroupOwenerOut groupPatner = new GroupOwenerOut();
        List<GroupOwenerOut> listGroupPatner = new ArrayList<>();
        List<GroupOwenerOut> patnerList = new ArrayList<>();

        try {

            logger.info("**************** get groupOwener  ***************** ");

            listGroupOwener = impReportDao.getGroupOwner(req);

            groupOwener.setDate(listGroupOwener.get(0).getDate());
            groupOwener.setName(listGroupOwener.get(0).getName());
            groupOwener.setCode(listGroupOwener.get(0).getCode());
            groupOwener.setCredit(listGroupOwener.get(0).getCredit());
            groupOwener.setDebbit(listGroupOwener.get(0).getDebbit());
            groupOwener.setTotalAccount(listGroupOwener.get(0).getTotalAccount());
            groupOwener.setCalClosingBalance(listGroupOwener.get(0).getCalClosingBalance());
            groupOwener.setClosingBalance(listGroupOwener.get(0).getClosingBalance());
            groupOwener.setRate(listGroupOwener.get(0).getRate());
            groupOwener.setTotalTxn(listGroupOwener.get(0).getTotalTxn());

            logger.info("**************** get groupPatner  ***************** ");

            listGroupPatner = impReportDao.getGroupPatner(req);


            groupPatner.setDate(listGroupPatner.get(0).getDate());
            groupPatner.setName(listGroupPatner.get(0).getName());
            groupPatner.setCode(listGroupPatner.get(0).getCode());
            groupPatner.setCredit(listGroupPatner.get(0).getCredit());
            groupPatner.setDebbit(listGroupPatner.get(0).getDebbit());
            groupPatner.setTotalAccount(listGroupPatner.get(0).getTotalAccount());
            groupPatner.setCalClosingBalance(listGroupPatner.get(0).getCalClosingBalance());
            groupPatner.setClosingBalance(listGroupPatner.get(0).getClosingBalance());
            groupPatner.setRate(listGroupPatner.get(0).getRate());
            groupPatner.setTotalTxn(listGroupPatner.get(0).getTotalTxn());


            logger.info("**************** get patnerList  ***************** ");

            patnerList = impReportDao.getPatnerDetail(req);

            result.setGroupOwener(groupOwener);
            result.setGroupPatner(groupPatner);
            result.setPaterList(patnerList);


        }catch (Exception e){
            e.printStackTrace();
            return result;
        }

        return result;
    }

    public GetRefRes getRef (GetRefReq req){
        List<GetRefOut> listData = new ArrayList<>();
        GetRefOut data = new GetRefOut();
        Message message = new Message();
        GetRefRes reslut = new GetRefRes();

        try {

            listData = impReportDao.getRef(req);


            if(listData.size() > 0){
                data.setBookingId(listData.get(0).getBookingId());
                data.setLdbRef(listData.get(0).getLdbRef());
                data.setEvenCode(listData.get(0).getEvenCode());
                data.setDateBooking(listData.get(0).getDateBooking());
                reslut.setData(data);
                message.setCode("00");
                message.setDetail("success");
                reslut.setMessage(message);

                return  reslut;
            }else {

                reslut.setData(data);
                message.setCode("01");
                message.setDetail(" data not found ");
                reslut.setMessage(message);
                return reslut;
            }

        }catch (Exception e){
            e.printStackTrace();
            reslut.setData(data);
            message.setCode("02");
            message.setDetail(" service not Avilable ");
            reslut.setMessage(message);
            return reslut;
        }
    }

    public List<ReportEventOut> getReportEvent (ReportEventReq req){

        List<ReportEventOut> result = new ArrayList<>();

        try {
            result = impReportDao.getReportEvent(req);

            return  result;

        }catch (Exception e){
            e.printStackTrace();
            return  result;
        }
    }

    public ReportByTicketRes getTicketReport (){

        List<ReportByTicket> listAllTicket = new ArrayList<>();
        ReportByTicket allTicket = new ReportByTicket();

        List<ReportByTicket> listGroupTicket = new ArrayList<>();

        ReportByTicketRes result = new ReportByTicketRes();

        try {
            listAllTicket = impReportDao.getAllTicket();

            allTicket.setAllTransaction(listAllTicket.get(0).getAllTransaction());
            allTicket.setToatalAmount(listAllTicket.get(0).getToatalAmount());
            allTicket.setDate(listAllTicket.get(0).getDate());
            allTicket.setAllTicket(listAllTicket.get(0).getAllTicket());

            listGroupTicket = impReportDao.getGroupTicket();


            result.setTotalTicket(allTicket);
            result.setSaleTicketByGroup(listGroupTicket);


        }catch (Exception e){
            e.printStackTrace();
            return  result;
        }
        return  result;
    }

}
