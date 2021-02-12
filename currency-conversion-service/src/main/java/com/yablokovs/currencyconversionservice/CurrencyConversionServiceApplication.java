package com.yablokovs.currencyconversionservice;

import brave.sampler.Sampler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@SpringBootApplication

//    STEP 21
// as a FEIGN CLIENT retrieve values from EXCHANGE-SERVICE
@EnableFeignClients("com.yablokovs.currencyconversionservice")
// become a EUREKA-CLIENT
@EnableDiscoveryClient
public class CurrencyConversionServiceApplication {

//creating a sampler called
//	@Bean
//	public Sampler defaultSampler() {
//		return Sampler.ALWAYS_SAMPLE;
//	}

	public static void main(String[] args) {
		SpringApplication.run(CurrencyConversionServiceApplication.class, args);
	}
}

