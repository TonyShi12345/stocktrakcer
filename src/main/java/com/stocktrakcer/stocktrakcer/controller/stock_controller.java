package com.stocktrakcer.stocktrakcer.controller;


import com.stocktrakcer.stocktrakcer.service.stock_service;
import com.stocktrakcer.stocktrakcer.wrapper.stock_wrapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

@RestController

public class stock_controller {
    Timer timer = new Timer();
    String result=" ";
    @RequestMapping("/start")
    public String atcivity(){
        ArrayList<String> stocks = new ArrayList<String>();
        stocks.add("TSLA");
        stocks.add("AAPL");
        stocks.add("ABNB");
        stocks.add("BTC-USD");
        stock_service stockService = new stock_service();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                result=" ";
                for(int i=0;i<stocks.size();i++) {
                    stock_wrapper stock = stockService.findStock(stocks.get(i));
                    result = result + " " + stock.getStock()+" $"+"<br>";
                }



            }
        };
        timer.scheduleAtFixedRate(task,0,10000);
        return result;

    }
}
