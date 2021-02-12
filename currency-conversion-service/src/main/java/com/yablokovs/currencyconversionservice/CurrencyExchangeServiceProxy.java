package com.yablokovs.currencyconversionservice;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

// STEP 22
// RIBBON
@RibbonClient(name="currency-exchange-service")

// STEP 21 // PROXY-interface + @FeignClient
// name of the service that we are going to consume
// URL attribute, write the port on which the currency-exchange-service is running
@FeignClient(name="currency-exchange-service"/*, url="localhost:8000"*/)
// STEP 22 // url not necessary
// configure in properties : currency-exchange-service.ribbon.listOfServers
// OR
// will fetch that URL from EUREKA through RIBBON

// disable currency-exchange-service @FeignClient
//@FeignClient(name="netflix-zuul-api-gateway-server")

public interface CurrencyExchangeServiceProxy {

    @GetMapping(/*"/currency-exchange-service/*/ "currency-exchange/from/{from}/to/{to}")
// retrieveExchangeValue - имя метода у сервиса
//    используем CurrencyConversionBean так как нет доступа
//    к классу ExchangeValue из другого сервиса
    CurrencyConversionBean convertCurrencyFeign(@PathVariable("from")String from, @PathVariable("to") String to);

}
