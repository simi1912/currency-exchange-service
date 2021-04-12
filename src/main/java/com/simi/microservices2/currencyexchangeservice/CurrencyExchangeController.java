package com.simi.microservices2.currencyexchangeservice;

import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class CurrencyExchangeController {

    private Environment environment;

    public CurrencyExchangeController(Environment environment) {
        this.environment = environment;
    }

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public ExchangeValue retrieveExchangeValue( @PathVariable("from") String from,
                                                @PathVariable("to") String to){
        ExchangeValue exchangeValue = new ExchangeValue(100L, from, to, BigDecimal.valueOf(65));
        exchangeValue.setPort(Integer.valueOf(environment.getProperty("local.server.port")));
        return exchangeValue;
    }

}
