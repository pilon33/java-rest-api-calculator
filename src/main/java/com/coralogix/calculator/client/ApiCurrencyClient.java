package com.coralogix.calculator.client;


import com.coralogix.calculator.client.Response.CurrencyResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "api-currency", url = "http://localhost:8080")
public interface ApiCurrencyClient {

    @GetMapping("/fixer/latest")
    CurrencyResponse find (@RequestParam String base , @RequestParam String symbols);
}
