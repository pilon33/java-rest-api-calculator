package com.coralogix.calculator.services;


import com.coralogix.calculator.client.ApiCurrencyClient;
import com.coralogix.calculator.client.Response.CurrencyResponse;
import com.coralogix.calculator.model.ExchangeRate;
import com.coralogix.calculator.repository.ExchangeRepository;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class ExchangeServiceImpl implements ExchangeService{
    @Autowired
    private ExchangeRepository repository;

    @Autowired
    private ApiCurrencyClient apiCurrencyClient;

    private RestTemplate restTemplate = new RestTemplate();
    @Override
    public List <ExchangeRate> getAllExchangeRate() {
        return repository.findAll();
    }

    @Override
    public ExchangeRate getExchangeApiCurrency(String originCurrency, String finalCurrency) {

//        String parameters = "?base="+originCurrency+"&symbols="+finalCurrency;
//
//        JsonNode jsonNode = restTemplate.getForObject("http://localhost:8080/fixer/latest"+ parameters, JsonNode.class);
//
//        String date = jsonNode.get("date").asText();
//
//        String valueExchange = null;
//        if (jsonNode.get("rates").get(originCurrency) != null){
//            valueExchange = jsonNode.get("rates").get(originCurrency).asText();
//        }else if (jsonNode.get("rates").get(finalCurrency) != null){
//            valueExchange = jsonNode.get("rates").get(finalCurrency).asText();
//        }
//        ExchangeRate toSave = new ExchangeRate();
//        toSave.setDate(date);
//        toSave.setValue(valueExchange);
//        return repository.save(toSave);


       CurrencyResponse response= apiCurrencyClient.find(originCurrency,finalCurrency);
       ExchangeRate exchangeRate = new ExchangeRate( 1,
               response.getBase(),
               finalCurrency,
               response.getDate(),
               response.getRates().get(finalCurrency).toString()

       );
                repository.save(exchangeRate);
        return exchangeRate;


    }
}
