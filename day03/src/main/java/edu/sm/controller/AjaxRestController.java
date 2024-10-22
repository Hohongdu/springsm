package edu.sm.controller;

import edu.sm.app.dto.CustDto;
import edu.sm.app.dto.Marker;
import edu.sm.app.service.CustService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
@Slf4j
@RequiredArgsConstructor
public class AjaxRestController {

    final CustService custService;

    @RequestMapping("/getmarkers")
    public Object getmarkers(@RequestParam("target") int target){
        log.info("Tager"+target);
        List<Marker> markers = new ArrayList<Marker>();
        if(target == 100){
            markers.add(new Marker(37.564472,126.990841,"순대국1","ss1.jpg", 101));
            markers.add(new Marker(37.544472,126.970841,"순대국2","ss2.jpg", 102));
            markers.add(new Marker(37.564472,126.970841,"순대국3","ss3.jpg", 103));
        }else if(target == 200){

        }else{

        }
        log.info("Size"+markers.size());

        return markers;
    }

    @RequestMapping("/getbike")
    public Object getbike(){
        JSONObject obj = new JSONObject();
        double lat = 36.789165;
        double lng = 127.064981;
        Random r = new Random();
        float num = r.nextFloat(1);
        lat += num/10;
        lng += num/10;
        obj.put("lat", lat);
        obj.put("lng", lng);
        return obj;
    }


    @RequestMapping("/checkid")
    public Object checkid(@RequestParam("rid") String id) throws Exception {
        JSONObject obj = new JSONObject();
        CustDto custDto = null;
        custDto = custService.get(id);
        obj.put("result", "0");
        if(custDto != null){
            obj.put("result", "1");
        }
        return obj;
    }


    @RequestMapping("/getctime")
    public Object getctime(){
        JSONObject obj = new JSONObject();
        // {'ctime','2023-12-12'}
        LocalDateTime now = LocalDateTime.now();
        obj.put("ctime", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(now));
        return obj;
    }
    @RequestMapping("/getdata")
    public Object getdata(){
        // [{"no":1, "desc":"연무5호"},{},{}]
        JSONArray arr = new JSONArray();
        for(int i=1;i<6;i++){
            JSONObject obj = new JSONObject();
            obj.put("no",i);
            obj.put("desc","연무5호");
            arr.add(obj);
        }
        return arr;
    }
}