package com.arnaud.back.blibliotheque;

import com.arnaud.back.blibliotheque.services.impl.JavaMailSenderImpl;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@EnableBatchProcessing
public class 	BlibliothequeApplication {

	@Autowired
	private JavaMailSenderImpl javaMailSenderImpl;

	public static void main(String[] args) {
		SpringApplication.run(BlibliothequeApplication.class, args);
	}

	@EventListener(ApplicationReadyEvent.class)
	public void sendMail(){
		javaMailSenderImpl.sendEmail("arnaud1720@gmail.com","ceci est un sujet","ceci est un corps de message");
	}

}

