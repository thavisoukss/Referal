package com.ldbbank.referal.Controllre;

import com.ldbbank.referal.Model.GetRefOut;
import com.ldbbank.referal.Model.GetRefReq;
import com.ldbbank.referal.Model.GetRefRes;
import com.ldbbank.referal.Model.Report.*;
import com.ldbbank.referal.Model.ReportByTicketRes;
import com.ldbbank.referal.Model.ReportEven.ReportEventOut;
import com.ldbbank.referal.Model.ReportEven.ReportEventReq;
import com.ldbbank.referal.Model.ReportOwner.GroupOwnerReq;
import com.ldbbank.referal.Model.ReportOwner.GroupOwnerRes;
import com.ldbbank.referal.Service.ReportService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("${base_url}")
public class Controller {

    private static final Logger logger = LogManager.getLogger(Controller.class);

    @Autowired
    ReportService reportService;

    @GetMapping("test")
    public  String test (){
        return "hello";
    }

    @CrossOrigin(origins = "*")
    @PostMapping("reportInfo")
     public List<ReportInfoRes> getReportInfo( @RequestBody ReportInfoReq req){

         List<ReportInfoRes> result = new ArrayList<>();

        try {

            result = reportService.getReportInfo(req);

        }catch (Exception e){
            e.printStackTrace();
            return result;
        }
        return result;

     }

    @CrossOrigin(origins = "*")
    @PostMapping("reportGroupTxn")
    public List<ReportGroupTxnRes> getReportGroupTxn(@RequestBody ReportInfoReq req){

        List<ReportGroupTxnRes> result = new ArrayList<>();

        try {

            result = reportService.getReportGroupTxn(req);

        }catch (Exception e){
            e.printStackTrace();
            return result;
        }
        return result;

    }
    @CrossOrigin(origins = "*")
    @PostMapping("getReportGroupTxnDetail")
    public ReportGroupTxnDetailRes getReportGroupTxnDetail (@RequestBody ReportInfoReq req){

        ReportGroupTxnDetailRes result = new ReportGroupTxnDetailRes();

        try {

            result = reportService.getReportGroupDetail(req);

        }catch (Exception e){
            e.printStackTrace();
            return result;
        }
        return result;
    }


    @CrossOrigin(origins = "*")
    @PostMapping("getReportTxnDetail")
    public List<ReportReferalDetailRes> getReportTxnDetail (@RequestBody ReportInfoReq req){

        List<ReportReferalDetailRes> result = new ArrayList<>();

        try {

            result = reportService.getReportDetail(req);

        }catch (Exception e){
            e.printStackTrace();
            return result;
        }
        return result;
    }

    @CrossOrigin(origins = "*")
    @PostMapping("getReporGroupOwnder")
    public GroupOwnerRes getReporGroupOwnder (@RequestBody GroupOwnerReq req){

        GroupOwnerRes result = new GroupOwnerRes();

        try {

            result = reportService.ReportOwnerGroup(req);

        }catch (Exception e){
            e.printStackTrace();
            return result;
        }
        return result;
    }


    @CrossOrigin(origins = "*")
    @PostMapping("getRefLDB")
    public GetRefRes getRefLDB (@RequestBody GetRefReq req){

        GetRefRes result = new GetRefRes();
        Message message = new Message();
        GetRefOut data = new GetRefOut();

        try {

            result = reportService.getRef(req);

        }catch (Exception e){
            e.printStackTrace();
            result.setData(data);
            message.setCode("02");
            message.setDetail(" service not Avilable ");
            result.setMessage(message);
            return result;
        }
        return result;
    }


    @CrossOrigin(origins = "*")
    @PostMapping("getEventReport")
    public List<ReportEventOut> getEventReport (@RequestBody ReportEventReq req){

        List<ReportEventOut>  result = new ArrayList<>();

        try {

            result = reportService.getReportEvent(req);

        }catch (Exception e){
            e.printStackTrace();

            return result;
        }
        return result;
    }


    @CrossOrigin(origins = "*")
    @GetMapping("ReportTikcet")
    public ReportByTicketRes  ReportTikcet (){

        ReportByTicketRes result = new ReportByTicketRes();

        try {

            result = reportService.getTicketReport();

        }catch (Exception e){
            e.printStackTrace();

            return result;
        }
        return result;
    }


}
