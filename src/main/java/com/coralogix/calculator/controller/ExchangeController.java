package com.coralogix.calculator.controller;

import com.coralogix.calculator.model.ExchangeRate;
import com.coralogix.calculator.model.Result;
import com.coralogix.calculator.services.AddService;
import com.coralogix.calculator.services.ExchangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/exchange-rate")
public class ExchangeController {

    @Autowired
    private ExchangeService exchangeService;

    @GetMapping
    public ResponseEntity <List <ExchangeRate>> getAllExchangeRate(){

        return ResponseEntity.ok(exchangeService.getAllExchangeRate());
    }


    @GetMapping("/exchange")
    public ResponseEntity <ExchangeRate> getExchange(@RequestParam String originCurrency, @RequestParam String finalCurrency){

        return ResponseEntity.ok(exchangeService.getExchangeApiCurrency(originCurrency,finalCurrency));
    }


    @GetMapping("/matrix")
    public ResponseEntity <String> generateMatrix(@RequestParam int userValue ){
        StringBuilder stringBuilder = new StringBuilder();
        int value = 0;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                int result = userValue * i +value;
                stringBuilder.append(result).append(" ");
                value = result;
            }
            stringBuilder.append("\n");
        }
        return  ResponseEntity.ok(stringBuilder.toString());
    }



}
