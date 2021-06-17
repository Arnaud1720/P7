package com.arnaud.front.blibliothequeFront;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;

@SpringBootApplication
@EnableFeignClients("com.arnaud.front.blibliothequeFront")
public class BlibliothequeFrontApplication {

	public static void main(String[] args) {
		SpringApplication.run(BlibliothequeFrontApplication.class, args);
	}

}
