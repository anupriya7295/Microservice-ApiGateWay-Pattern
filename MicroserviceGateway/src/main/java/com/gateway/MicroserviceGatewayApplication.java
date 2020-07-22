package com.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

import com.gateway.filter.GateWayFilter;

@SpringBootApplication
@EnableEurekaClient
@EnableZuulProxy
public class MicroserviceGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceGatewayApplication.class, args);
	}
	
	@Bean
  public GateWayFilter gateWayFilter() {
     return new GateWayFilter();
  }

}
