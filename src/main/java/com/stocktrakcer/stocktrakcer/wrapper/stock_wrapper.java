package com.stocktrakcer.stocktrakcer.wrapper;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.With;
import org.springframework.boot.SpringApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import yahoofinance.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Timer;

@Getter
@With

@AllArgsConstructor
public class stock_wrapper {

    private final Stock stock;
    private final LocalDateTime lastAccessed;

    public stock_wrapper(final Stock stock) {

        this.stock = stock;
        lastAccessed = LocalDateTime.now();
    }

    public Stock getStock() {

        return stock;
    }


}
