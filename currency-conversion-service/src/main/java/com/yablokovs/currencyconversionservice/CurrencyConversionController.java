package com.yablokovs.currencyconversionservice;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;


@RestController
public class CurrencyConversionController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    // FEIGN
    @Autowired
    CurrencyExchangeServiceProxy currencyExchangeServiceProxy;


    //    STEP 20   //  dumb way to call other service = RestTemplate
    @GetMapping("/currency-converter/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversionBean convertCurrency
    (@PathVariable String from, @PathVariable String to, @PathVariable BigDecimal quantity) {

        Map<String, String> uriVariables = new HashMap<>();
        uriVariables.put("from", from);
        uriVariables.put("to", to);

//        We use RestTemplate() constructor to invoke an external service
        ResponseEntity<CurrencyConversionBean> responseEntity = new RestTemplate()
                .getForEntity("http://localhost:8000/currency-exchange/from/{from}/to/{to}",
                        CurrencyConversionBean.class, uriVariables);

//        bean must be completely CORRESPONDING
        CurrencyConversionBean conversionBean = responseEntity.getBody();

        BigDecimal conversionMultiple = conversionBean.getMultiplier();
        return new CurrencyConversionBean(
                conversionBean.getId(),
                from, to,
                conversionMultiple,
                quantity,
                quantity.multiply(conversionMultiple),
                conversionBean.getPort());
    }

//    STEP 21 SMART way to call another service = FEIGN
    @GetMapping("/currency-converter-feign/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversionBean convertCurrencyFeign
            (@PathVariable String from, @PathVariable String to, @PathVariable BigDecimal quantity) {

        // FEIGN
        CurrencyConversionBean conversionBean = currencyExchangeServiceProxy.convertCurrencyFeign(from, to);

        BigDecimal conversionMultiple = conversionBean.getMultiplier();

        logger.info("{}", conversionBean);

        return new CurrencyConversionBean(
                conversionBean.getId(),
                from, to,
                conversionMultiple,
                quantity,
                quantity.multiply(conversionMultiple),
                conversionBean.getPort());
    }
}
