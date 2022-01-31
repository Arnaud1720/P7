package com.arnaud.back.blibliotheque;

import com.arnaud.back.blibliotheque.model.Pret;
import com.arnaud.back.blibliotheque.services.impl.EmailSenderServiceImpl;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.time.LocalDate;
import java.time.LocalDateTime;

@SpringBootApplication
@EnableSwagger2
@EnableBatchProcessing
public class 	BlibliothequeApplication {

	@Autowired
	EmailSenderServiceImpl emailSenderService;

	public static void main(String[] args) {
		SpringApplication.run(BlibliothequeApplication.class, args);


	}
	/**
	 * enlever l'anti virus avant de lancer le main
	 */
	@EventListener(value = ApplicationReadyEvent.class)
	public void triggerMail(){
		emailSenderService.sendEmailMessage("m.sibille@mairie-audenge.fr",
				"test d'envoi de mais depuis API_REST","API SENDER_MAIL");
	}
}

