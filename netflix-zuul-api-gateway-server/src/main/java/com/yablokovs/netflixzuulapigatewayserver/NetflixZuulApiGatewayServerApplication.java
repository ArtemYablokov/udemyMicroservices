package com.yablokovs.netflixzuulapigatewayserver;

import brave.sampler.Sampler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
// ZUUL
@EnableZuulProxy
@EnableDiscoveryClient
public class NetflixZuulApiGatewayServerApplication {

	@Bean
//creating a sampler called
	public Sampler defaultSampler() {
		return Sampler.ALWAYS_SAMPLE;
	}

	public static void main(String[] args) {
		SpringApplication.run(NetflixZuulApiGatewayServerApplication.class, args);
	}
}