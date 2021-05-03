package com.stocktrakcer.stocktrakcer.service;


import com.stocktrakcer.stocktrakcer.wrapper.stock_wrapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import yahoofinance.*;

import java.io.IOException;
import java.math.BigDecimal;

@AllArgsConstructor
public class stock_service {


    public stock_wrapper findStock(final String stock){

        try{
            return new stock_wrapper(YahooFinance.get(stock));
        }
        catch (IOException e){
            System.out.println("Error");
        }
        return null;
    }
    public BigDecimal findprice(final stock_wrapper stock_wrapper)throws IOException{
        return stock_wrapper.getStock().getQuote(true).getPrice();
    }


}
