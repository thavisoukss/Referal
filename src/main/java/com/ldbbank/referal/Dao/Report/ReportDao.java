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

import java.util.List;

public interface ReportDao {
    List<ReportInfoRes> getReportInfo (ReportInfoReq req);

    List<ReportGroupTxnRes> getReportGroupTxn (ReportInfoReq req);

    List<ReportGroupTxnRes> getReportGroupTxnByCcy (ReportInfoReq req , String ccy);

    List<ReportReferalDetailRes> getReferalDetail (ReportInfoReq req);

    List<GroupOwenerOut> getGroupOwner (GroupOwnerReq req);
    List<GroupOwenerOut> getGroupPatner (GroupOwnerReq req);

    List<GroupOwenerOut> getPatnerDetail (GroupOwnerReq req);

    List<GetRefOut> getRef (GetRefReq req);

    List<ReportEventOut> getReportEvent (ReportEventReq req);

    List<ReportByTicket> getAllTicket ();
    List<ReportByTicket> getGroupTicket ();



}
